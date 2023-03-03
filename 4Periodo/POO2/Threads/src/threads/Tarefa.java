
package threads;

import java.security.SecureRandom;

public class Tarefa implements Runnable{

    public String nome;

    public Tarefa(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

  
    public static void main(String[] args) throws InterruptedException {
        Tarefa teste = new Tarefa("Tarefa 1");
        Thread thre = new Thread(teste);

        thre.start();

    }

    @Override
    public void run(){
        System.out.println("Hello thread "+getNome());
        try {
            Thread.sleep((new SecureRandom().nextInt(2)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Encerramento thread "+getNome());        
    }
    
}
