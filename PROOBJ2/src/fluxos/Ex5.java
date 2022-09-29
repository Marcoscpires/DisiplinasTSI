package fluxos;

import java.util.Arrays;
import java.util.List;

public class Ex5 {
    
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"),
                new Fish("Free Willy"), new Spider(), new Fish("Jaws"));
        
        System.out.println(animals.stream().mapToInt(Animal::getLegs).sum());
   
        
    }
}
