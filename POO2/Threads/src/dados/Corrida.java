package dados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import threads.Tarefa;

public class Corrida {
  
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Gol Turbo 500CV"));
        carros.add(new Carro("Celta AP"));
        carros.add(new Carro("Kombi"));
        List<Thread> lista = new ArrayList<Thread>();
        lista.add(new Thread(carros.get(0)));
        lista.add(new Thread(carros.get(1)));
        lista.add(new Thread(carros.get(2)));
        
         lista.stream().forEach(Thread::start);
         lista.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        carros.stream().min(Comparator.comparing(Carro::getTempo)).ifPresent(n->System.out.println("vencedor é: " + n.getId()));
        
        
         
         
    }
        
    
}
