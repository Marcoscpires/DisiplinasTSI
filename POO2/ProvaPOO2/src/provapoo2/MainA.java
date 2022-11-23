package provapoo2;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainA {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String linha = "";                
        BufferedReader reader = new BufferedReader(new FileReader("LFT_2022.csv"));
        while ((linha = reader.readLine()) != null){
            System.out.println(linha);
            
        }
      
    }
           
            
    
}
