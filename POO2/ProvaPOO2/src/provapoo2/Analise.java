package provapoo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Analise {
    
    public static void main(String[] args) {
        BufferedReader fos = new BufferedReader(new FileReader("ColecaoCotacaoLFT22.txt"));
        ObjectInputStream oos = new ObjectInputStream(fos.readLine());
    }
    
    
}
