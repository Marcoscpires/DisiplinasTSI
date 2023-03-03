package beans;

import dados.Categoria;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;

@Named(value = "palavrasBean")
@ApplicationScoped
public class PalavrasBean {

    private LinkedList<Categoria> categorias;
    private LinkedList<SelectItem> listaCategoria;
    private ArrayList<String> palavra;
    private Categoria catSel;
    private String newP;

    public String getNewP() {
        return newP;
    }

    public void setNewP(String newP) {
        this.newP = newP;
    }

    public Categoria getCatSel() {
        return catSel;
    }

    public void setCatSel(Categoria catSel) {
        this.catSel = catSel;
    }

    public PalavrasBean() {

        categorias = new LinkedList<>();
        //paises
        palavra = new ArrayList<>();
        palavra.add("brasil");
        palavra.add("portugal");
        palavra.add("africa");
        palavra.add("espanha");
        palavra.add("afeganistao");
        palavra.add("inglaterra");
        categorias.add(new Categoria(1, "Países", palavra));

        //cidades    
        palavra = new ArrayList<>();
        palavra.add("cascavel");
        palavra.add("toledo");
        palavra.add("umuarama");
        palavra.add("curitiba");
        palavra.add("xangai");
        palavra.add("pequim");
        categorias.add(new Categoria(2, "Cidades", palavra));

        //carros
        palavra = new ArrayList<>();
        palavra.add("voyage");
        palavra.add("corvette");
        palavra.add("aventador");
        palavra.add("palio");
        categorias.add(new Categoria(3, "Carros", palavra));

        //paises
        palavra = new ArrayList<>();
        palavra.add("tigre");
        palavra.add("elefante");
        palavra.add("girafa");
        palavra.add("mamute");
        categorias.add(new Categoria(4, "Animais", palavra));

        listaCategoria = new LinkedList<>();
        listaCategoria.add(new SelectItem(null, "Selecione a Categoria:"));
        for (Categoria c : categorias) {
            listaCategoria.add(new SelectItem(c, c.getCategoria()));
        }
    }

    public List<SelectItem> getListaCategoria() {
        return listaCategoria;
    }

    public Categoria getCategorias(int id) {
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
//    
//    FileOutputStream file = new FileOutputStream("file.txt");
//
//            // Creates an ObjectOutputStream
//            ObjectOutputStream output = new ObjectOutputStream(file);
//
//            // writes objects to output stream
//            output.writeObject(categorias);
    
    public String addCategoria(){
        palavra = catSel.getPalavras();
        palavra.add(newP);
        catSel.setPalavras(palavra);
        catSel = null;
        newP = "";
        return null;      
    }
    

}
