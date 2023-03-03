
package dados;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {
    
    int id;
    String categoria;
    ArrayList<String> palavras;

    public Categoria(int id, String categoria, ArrayList<String> palavras) {
        this.id = id;
        this.categoria = categoria;
        this.palavras = palavras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getPalavras() {
        return palavras;
    }

    public void setPalavras(ArrayList<String> palavras) {
        this.palavras = palavras;
    }
}
