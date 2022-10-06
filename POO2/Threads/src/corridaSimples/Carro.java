package corridaSimples;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

public class Carro implements Runnable{

    private String id;
    private Instant tempo;
    Random random = new Random();

    public Carro(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTempo() {
        return tempo;
    }

    public void setTempo(Instant tempo) {
        this.tempo = tempo;
    }

    public void run() {
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println("O carro " + id + " está na posição " + i);
                Thread.sleep((500 + random.nextInt(501)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("O carro " + id + " terminou no tempo: " + (tempo = Instant.now()));
    }

    public static void main(String[] args) {

    }

}
