package poo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3 {
    
    public static void main(String[] args) throws IOException{
        
        List<String> palavras = Files.readAllLines(Paths.get("br-sem-acentos.txt"))
                .stream()
                .filter(palavra -> palavra.length()<5 && palavra.startsWith("a"))
                .collect(Collectors.toList());
        
        System.out.println(palavras);
    }
    
}
