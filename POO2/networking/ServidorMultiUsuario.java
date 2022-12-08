import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import java.util.Map;

public class ServidorMultiUsuario {
 	static Map<Integer,OutputStream> id_fluxo = new HashMap<Integer,OutputStream>();
	static Map<Integer,Integer> conexoes = new HashMap<Integer,Integer>(); 
	public static void main(String[] args) throws Exception {
	    
		try (ServerSocket listener = new ServerSocket(59898)) {
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

		public int getId(){
			return this.id;
		}

		ServicoSocket(Socket socket) {
			this.socket = socket;
			this.id = n.getAndIncrement();
		}

		public OutputStream getFluxo() throws IOException{
			return socket.getOutputStream();
		}

		@Override
		public void run() {
			System.out.println("Conectado: Cliente " +id+ " " + socket);

			try {
				Scanner in = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				while (in.hasNextLine()) {
					String s = (String)in.nextLine();
					if(s.equals("/listar")){
					out.print(id_fluxo.keySet());
					}else
					out.println(s);
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
