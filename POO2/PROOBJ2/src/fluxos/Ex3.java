package fluxos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Ex3 {
    
    public static void main(String[] args) {
        Predicate<Animal> isPet = Pet.class::isInstance;
        Predicate<Animal> isWild = isPet.negate();

        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"),
                new Fish("Free Willy"), new Spider(), new Fish("Jaws"));
    
        
        animals.stream()
                .max(Comparator.comparing(Animal::getLegs))              
                .ifPresent(n->System.out.println(n.getClass().getName()));
        
    }
    }
        
    

