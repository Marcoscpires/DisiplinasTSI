package provapoo2;

public class ThreadA extends Thread {

    private static Boolean stop = true;

    public static void stopThread() {
        stop = false;
    }

//    public static void main(String[] args) throws InterruptedException {
//        ThreadA thre = new ThreadA();
//        thre.start();
//        Thread.sleep(10000);
//        stopThread();
//
//    }

    public void run() {
        while (stop) {
            System.out.println("Olá A");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
