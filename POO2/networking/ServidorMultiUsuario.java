
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServidorMultiUsuario {

    static Map<Integer, OutputStream> id_fluxo = new HashMap<Integer, OutputStream>();
    static Map<Integer, Integer> conexoes = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {

        try ( ServerSocket listener = new ServerSocket(59898)) {
            System.out.println("Servidor executando...");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            while (true) {
                ServicoSocket novoCliente = new ServicoSocket(listener.accept());
                pool.execute(novoCliente);
                id_fluxo.put(novoCliente.getId(), novoCliente.getFluxo());

            }
        }
    }

    private static class ServicoSocket implements Runnable {

        private static final AtomicInteger n = new AtomicInteger(1);
        private int id;
        private Socket socket;

        public int getId() {
            return this.id;
        }

        ServicoSocket(Socket socket) {
            this.socket = socket;
            this.id = n.getAndIncrement();
        }

        public OutputStream getFluxo() throws IOException {
            return socket.getOutputStream();
        }

        @Override
        public void run() {
            System.out.println("Conectado: Cliente " + id + " " + socket);

            try {
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(this.getFluxo(), true);
				boolean conectado = false;
                while (in.hasNextLine()) {
                    if (conexoes.containsKey(this.id)) {
                        String msn = (String) in.nextLine();
						if(!conectado){
						for (Map.Entry<Integer, Integer> conex : conexoes.entrySet()) {
							Integer origem = conex.getKey();
							Integer destino = conex.getValue();
							if(origem == this.id){
								for (Map.Entry<Integer, OutputStream> entry : id_fluxo.entrySet()) {
									Integer key = entry.getKey();
									OutputStream saida = entry.getValue();
									if(key == destino){
										out = new PrintWriter(saida,true);
										conectado = true;
									}
								}
							}
						}
					}else{
							out.println(msn);						
						}
					}else {
                        String s = (String) in.nextLine();
                        List<Integer> usuarios = new ArrayList<>();
                        if (s.equals("/listar")) {
                            for (Map.Entry<Integer, OutputStream> entry : id_fluxo.entrySet()) {
                                Integer key = entry.getKey();
                                if (this.id != key) {
                                    usuarios.add(key);
                                }
                            }
                            out.println("Usuarios Onlines: " + usuarios + ". Digite o id do usuario que deseja se conectar:");
                            int select_id = (Integer) in.nextInt();
                            if (usuarios.contains(select_id)) {
                                out.println("vc está conectado á: " + select_id);
                                conexoes.put(this.id, select_id);
                                conexoes.put(select_id, this.id);
                            } else {
                                out.print(select_id + " não é um id valido.");
                            }
                        } else {
                            out.println(s);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro:" + socket);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
                id_fluxo.remove(this.id);
                System.out.println("Socket fechado: " + socket);
            }
        }
    }

}
