package provapoo2;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        ThreadA thrA = new ThreadA();
        ThreadB thrB = new ThreadB();
        Thread tB = new Thread(thrB);

        thrA.start();
        tB.start();
        Thread.sleep(30000);
        ThreadA.stopThread();
        ThreadB.stopThread();
    }

}
