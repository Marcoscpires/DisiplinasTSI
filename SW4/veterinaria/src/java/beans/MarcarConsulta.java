package beans;

import dao.AnimalDAO;
import dao.ConsultaDAO;
import dao.HorarioIndisponivel;
import entidade.Animal;
import entidade.Consulta;
import entidade.Veterinario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Named(value = "marcarConsulta")
@SessionScoped
public class MarcarConsulta implements Serializable {
 
    @Inject
    AnimalDAO animalDAO;
    
    @Inject
    ConsultaDAO consultaDAO;
  
    private ArrayList<Consulta> consultas;
    private Consulta consulta;
    private boolean editando = false;
    private Animal animalEscolhido, animalFiltro;
    

    public MarcarConsulta() {
    }

    public Animal getAnimalEscolhido() {
        return animalEscolhido;
    }
    
    public List<SelectItem> getAnimais() {
        return animalDAO.getAnimais();
    }

    public void setAnimalEscolhido(Animal animalEscolhido) {
        this.animalEscolhido = animalEscolhido;
    }

    @PostConstruct
    public void init() {        
        // Neste ponto, os daos já foram injetados. Poderiam ser usados.
        consulta = new Consulta();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String confirmar() {
        if (!editando) {
            try {
                consultaDAO.incluir(consulta);
            } catch(HorarioIndisponivel hi) {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage("Esse Veterinario já tem uma consulta marcada nesse horario"));
            }
        }
        editando = false;
        tabela();
        consulta = new Consulta();
        return null;
        }

    public void remover(Consulta cons) {
        consultaDAO.remover(cons);
        consultas.remove(cons);
    }

    public void editar(Consulta c) {
        consulta = c;
        editando = true;
    }

    public String cancelar() {
        editando = false;
        consulta = new Consulta();
        return null;
    }

    public List<SelectItem> getVeterinariosCorrespondentes() {
        if (animalEscolhido == null) {
            return new LinkedList<>();
        }
        LinkedList<SelectItem> itens = new LinkedList<>();
        itens.add(new SelectItem(null, "Selecione um veterinario"));
        for (Veterinario vet : animalEscolhido.getVeterinarios()) {
            itens.add(new SelectItem(vet, vet.getNome()));
        }
        return itens;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Animal getAnimalFiltro() {
        return animalFiltro;
    }

    public void setAnimalFiltro(Animal animalFiltro) {
        this.animalFiltro = animalFiltro;
    }
    
    public String tabela() {
        consultas = consultaDAO.buscar();
        return null;
    }

//    public int getAnoInicio() {
//        return anoInicio;
//    }
//
//    public void setAnoInicio(int anoInicio) {
//        this.anoInicio = anoInicio;
//    }
//
//    public int getAnoFim() {
//        return anoFim;
//    }
//
//    public void setAnoFim(int anoFim) {
//        this.anoFim = anoFim;
//    }
//
    
}