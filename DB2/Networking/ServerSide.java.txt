import java.io.*;
import java.net.*;

public class ServerSide {
  private Socket socket = null;
  private ServerSocket server = null;
  private DataInputStream in = null;

  public ServerSide(int port) {
    try {
      server = new ServerSocket(port);
      System.out.println("Server started");
      System.out.println("Waiting for a client ...");
      socket = server.accept();
      System.out.println("Client accepted");

      in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
      String line = "";

      while (true) {
        try {
          line = in.readUTF();
          System.out.println(line);
        }
        catch (EOFException i) {
          break;
        }
        catch (IOException i) {
          System.out.println(i);
        }
      }
      
      System.out.println("Closing connection");
      socket.close();
      in.close();
    }
    catch (IOException i) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    ServerSide server = new ServerSide(5000);
  }
}
