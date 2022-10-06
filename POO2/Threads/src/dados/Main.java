package dados;


public class Main {
    
    public static void main(String[] args) {
        Thread thre = new Thread(new Carro("Gol Turbo 500CV"));
        thre.start();
        
    }
}
