
package Multiplos;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Tarefa implements Runnable{

    private int n;
    private int qtde=0;
    private long soma=0; 

    public Tarefa(int n){
        this.n = n;
    }

    public int getQtde(){
        return this.qtde;
    }

    

    public int getN(){
        return this.n;
    }


    @Override
    public void run(){
        for(int i = n;i <= 5000000;i+=n){
            qtde++;
            soma += i;
        }
        System.out.println("Quantidade de Mutiplos de "+n+": "+qtde+" Soma: "+soma);
    
    }
    
}
