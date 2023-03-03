package provapoo2;

public class ThreadB implements Runnable {
    
private static Boolean stop = true;
    
public static void stopThread() {
        stop = false;
    }
    
    @Override
    public void run() {
         while (stop) {
            System.out.println("Olá B");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    } 
    
}
