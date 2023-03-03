
package poo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Ex5 {
    
    public static void main(String[] args)  throws IOException{
          Files.readAllLines(Paths.get("br-sem-acentos.txt"))
                .stream()
                .collect(Collectors.groupingBy(palavra -> palavra.substring(0,1)))
                .forEach((index,list) -> {System.out.println(index + ": " + list);}) ;

    }
}
