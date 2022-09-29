
package poo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex2 {
    
    public static void main(String[] args) throws IOException{
       Files.readAllLines(Paths.get("br-sem-acentos.txt"))
                .stream()
                .filter(palavra -> palavra.length()<5 && palavra.startsWith("a"))
                .forEach(System.out::println);
    }
    
}
