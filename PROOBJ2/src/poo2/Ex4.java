
package poo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

public class Ex4 {
    
    public static void main(String[] args) throws IOException{

        Files.readAllLines(Paths.get("br-sem-acentos.txt"))
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst()
                .ifPresent(System.out::println);
        
        
        
        
        
    }
}
