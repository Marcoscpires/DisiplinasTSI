
package Multiplos;

import java.util.ArrayList;
import java.util.List;
import threads.Tarefa;

public class ExemploThread {

    public static void main(String[] args) {
        
        List<Tarefa> somas = new ArrayList<Tarefa>();
        somas.add(new Tarefa(3));
        somas.add(new Tarefa(4));
        somas.add(new Tarefa(7));
        somas.add(new Tarefa(9));
        somas.add(new Tarefa(11));

        List<Thread> lista = new ArrayList<Thread>();
        lista.add(new Thread(somas.get(0)));
        lista.add(new Thread(somas.get(1)));
        lista.add(new Thread(somas.get(2)));
        lista.add(new Thread(somas.get(3)));
        lista.add(new Thread(somas.get(4)));


       
        lista.stream().forEach(Thread::start);

        lista.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(somas.stream().mapToInt(x -> x.getQtde()).sum());

        System.out.println("fim");

    }

}