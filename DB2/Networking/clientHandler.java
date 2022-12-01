import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;


public class clientHandler implements Runnable{
    private Socket socket;
    private static final AtomicInteger n = new AtomicInteger(1);
    private int id;


    public clientHandler(Socket socket){
        this.socket = socket;
        this.id = n.getAndIncrement();
    }
    public synchronized void run(){
        System.out.println("Client "+this.id + " accepted");
        DataInputStream in = null;
        while (true) {
            try {
              in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
              String line = "";
              line = in.readUTF();
              System.out.println(this.id +" "+ line);
            }
            catch (EOFException i) {
              break;
            } catch (IOException e) {
                e.printStackTrace();
            }
          }
          try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}