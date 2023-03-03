import javafx.beans.property.SimpleDoubleProperty;

public class TesteThread2 implements Runnable {
    public static void main(String[] args) {
        TesteThread2 teste = new TesteThread2();
        Thread thre = new Thread(teste);

        thre.start();

    }
    @Override
    public void run(){
        System.out.println("Olá Thread");        
    }
}