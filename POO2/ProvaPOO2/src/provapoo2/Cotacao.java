package provapoo2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Cotacao implements Serializable {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int n = 0;
        String linha = "";             
        Cotacao c = new Cotacao();
        ArrayList<Cotacao> clist = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("LFT_2022.csv"));
        while ((linha = reader.readLine()) != null){
            if(n>0){
            String[] campos = linha.split(",");
            c.dia=campos[0];
            c.taxaCompra=campos[1];
            c.taxaVenda=campos[2];
            c.puCompra=campos[3];
            c.puVenda=campos[4];
            c.puBase=campos[5];
            clist.add(c);
            c = new Cotacao();
            }
            n++;
        }
        clist.stream().forEach(System.out::println);
         FileOutputStream fos = new FileOutputStream("ColecaoCotacaoLFT22.txt");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         
         oos.writeObject(clist);
         
  
    }
    
    private static String vencimento;
    private String dia;
    private String taxaCompra;
    private String taxaVenda;
    private String puCompra;
    private String puVenda;
    private String puBase;

    public Cotacao() {
    }

    public static String getVencimento() {
        return vencimento;
    }

    public static void setVencimento(String vencimento) {
        Cotacao.vencimento = vencimento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTaxaCompra() {
        return taxaCompra;
    }

    @Override
    public String toString() {
        return "Cotacao{ " + dia + "," + taxaCompra + "," + taxaVenda + "," + puCompra + "," + puVenda + "," + puBase + '}';
    }

    public void setTaxaCompra(String taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public String getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(String taxaVenda) {
        this.taxaVenda = taxaVenda;
    }

    public String getPuCompra() {
        return puCompra;
    }

    public void setPuCompra(String puCompra) {
        this.puCompra = puCompra;
    }

    public String getPuVenda() {
        return puVenda;
    }

    public void setPuVenda(String puVenda) {
        this.puVenda = puVenda;
    }

    public String getPuBase() {
        return puBase;
    }

    public void setPuBase(String puBase) {
        this.puBase = puBase;
    }

}
