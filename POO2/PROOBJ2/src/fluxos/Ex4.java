package fluxos;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex4 {
    public static void main(String[] args) {
//        System.out.println(new SecureRandom().nextInt(10));
//        Stream.generate(lambda expression) lambda Infinita;
//        Stream.generate(()->"MARCOS").forEach(System.out::println);
//
//        IntStream.generate(
//                ()-> new SecureRandom().nextInt(10000))
//                .forEach(System.out::println);

Supplier<Animal> a1 = Cat::new;
Supplier<Animal> a2 = ()-> new Fish("Jean");
Supplier<Animal> a3 = Spider::new;

List<Supplier<Animal>> suppliers = Arrays.asList(a1,a2,a3);

IntStream.generate(()-> new SecureRandom().nextInt(suppliers.size()))
        .mapToObj(suppliers::get)
        .map(Supplier::get)
        .limit(100)
        .collect(Collectors.toList())
        .forEach(System.out::println);

// Stream.generate(() -> suppliers.get(new SecureRandom().nextInt(suppliers.size())).get())
//                .limit(100)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);









    
    }
}
