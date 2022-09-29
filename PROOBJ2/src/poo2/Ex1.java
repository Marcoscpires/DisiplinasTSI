
package poo2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ex1 {
    
    public static void main(String[] args) throws Exception{
        
        Files.readAllLines(Paths.get("br-sem-acentos.txt"))
                .stream()
                .filter(palavra -> palavra.equals(new StringBuilder(palavra).reverse().toString()))
                .forEach(System.out::println);


    }
       
        
        
    }
    

