package beans;

import dados.Categoria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "jogoBean")
@SessionScoped
public class JogoBean implements Serializable {

    private Categoria categoriaSelecionada;
    private Random rand = new Random();
    private String sorteada, acertos;
    private int erros;
    private char letra;
    private String jogados = "";
    private char[] sorteadasplit;
    private char[] acertossplit;
    private String padivinhadas = "";
    private String perradas = "";

    public String getPadivinhadas() {
        return padivinhadas;
    }

    public void setPadivinhadas(String padivinhadas) {
        this.padivinhadas = padivinhadas;
    }

    public String getPerradas() {
        return perradas;
    }

    public void setPerradas(String perradas) {
        this.perradas = perradas;
    }

    public JogoBean() {
    }

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }

    public String sortear() {
        ArrayList<String> palavras = categoriaSelecionada.getPalavras();
        if (palavras.size() < 1) {
            FacesContext.getCurrentInstance().addMessage(
                    "categoria:ctsel", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "sem palavras",
                            "Todas as palavras dessa categoria já foram jogadas"));
            return null;
        }
        int pos = rand.nextInt(palavras.size());
        sorteada = palavras.get(pos);
        palavras.remove(pos);
        categoriaSelecionada.setPalavras(palavras);
        sorteadasplit = sorteada.toCharArray();
        acertos = "";
        for (int i = 0; i < sorteada.length(); i++) {
            acertos += "_";
        }
        acertossplit = acertos.toCharArray();
        erros = 0;
        jogados = "";
        categoriaSelecionada = null;
        return null;
    }

    public String tentativa() {
        if(sorteada.equals(acertos)){
            FacesContext.getCurrentInstance().addMessage(
                    "tentativa:letra", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "FIM",
                            "Sorteir uma nova palavra"));
            letra = ' ';
            return null;
        }
        letra = Character.toLowerCase(letra);
        if (letra < 97 || letra > 122) {
            FacesContext.getCurrentInstance().addMessage(
                    "tentativa:letra", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Invalida",
                            "Letra invalida"));
            letra = ' ';
            return null;
        }
        if ((jogados.indexOf(letra)) > -1) {
            FacesContext.getCurrentInstance().addMessage(
                    "tentativa:letra", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Já Existe",
                            "Você ja tentou essa letra"));
            letra = ' ';
            return null;
        }
        if (sorteada.indexOf(letra) > -1) {
            for (int i = 0; i < sorteadasplit.length; i++) {
                if (sorteadasplit[i] == letra) {
                    acertossplit[i] = Character.toUpperCase(letra);
                }
            }
            acertos = "";
            for (int j = 0; j < acertossplit.length; j++) {
                acertos += acertossplit[j];
            }
            jogados = jogados + Character.toUpperCase(letra);
            letra = ' ';
            if (sorteada.equals(acertos.toLowerCase())) {
                vitoria();
                return null;
            }
            return null;
        } else {
            erros++;
            FacesContext.getCurrentInstance().addMessage(
                    "tentativa:letra", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Errou",
                            "Letra não está na palavra"));
            jogados = jogados + Character.toUpperCase(letra);
            letra = ' ';
            if (erros >= 6) {
                gameOver();
                return null;
            }
            return null;

        }

    }

    public String vitoria() {
        padivinhadas += sorteada.toUpperCase() + ", ";
        jogados = "";
        acertos = "";
        sorteada = "";
        return null;
    }

    public String gameOver() {
        perradas += sorteada.toUpperCase() + ", ";
        acertos = "";
        sorteada = "";
        jogados = "";
        
        return null;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String getJogados() {
        return jogados;
    }

    public void setJogados(String jogados) {
        this.jogados = jogados;
    }

    public void tentativa(char letra) {

    }

    public String getSorteada() {
        return sorteada;
    }

    public void setSorteada(String sorteada) {
        this.sorteada = sorteada;
    }

    public String getAcertos() {
        return acertos;
    }

    public void setAcertos(String acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

}
