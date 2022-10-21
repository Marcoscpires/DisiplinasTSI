/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AnimalDAO;
import dao.ConsultaDAO;
import dao.ConsultaJaMarcada;
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

/**
 *
 * @author marco
 */
@Named(value = "marcarConsulta")
@SessionScoped
public class MarcarConsulta implements Serializable {
 
    @Inject
    AnimalDAO animalDAO;
    
    @Inject
    ConsultaDAO consultaDAO;
  
    private ArrayList<Consulta> filtrados;
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
            } catch(ConsultaJaMarcada cjm) {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage("Essa consulta já foi marcada"));
            }
        }
        editando = false;
        consulta = new Consulta();
//      filtrar();
        return null;
    }

    public void remover(Consulta cons) {
        consultaDAO.remover(cons);
        filtrados.remove(cons);
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

    public List<SelectItem> getVeterinariosSelecionado() {
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

    public ArrayList<Consulta> getFiltrados() {
        return filtrados;
    }

    public void setFiltrados(ArrayList<Consulta> filtrados) {
        this.filtrados = filtrados;
    }

    public Animal getAnimalFiltro() {
        return animalFiltro;
    }

    public void setAnimalFiltro(Animal animalFiltro) {
        this.animalFiltro = animalFiltro;
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
//    public String filtrar() {
//        filtrados = consultaDAO.buscar(animalFiltro, anoInicio, anoFim);
//        return null;
//    }
}