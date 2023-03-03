
package threads;

import java.util.ArrayList;
import java.util.List;
import threads.Tarefa;

public class ExemploThread {

    public static void main(String[] args) {
        List<Thread> lista = new ArrayList<Thread>();
        lista.add(new Thread(new Tarefa("tarefa 1")));
        lista.add(new Thread(new Tarefa("tarefa 2")));
        lista.add(new Thread(new Tarefa("tarefa 3")));
        lista.add(new Thread(new Tarefa("tarefa 4")));
        lista.add(new Thread(new Tarefa("tarefa 5")));

        lista.stream().forEach(Thread::start);

        lista.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("fim");

    }

}