package provapoo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Analise {
    
    public static void main(String[] args) {
        FileOutputStream fos = new FileInputStream("ColecaoCotacaoLFT22.txt");
        ObjectInputStream oos = new ObjectInputStream(fos);
    }
    
    
}
