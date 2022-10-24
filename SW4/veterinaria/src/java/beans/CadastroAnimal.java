/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AnimalDAO;
import dao.AnimalJaCadastrado;
import dao.ConsultaDAO;
import dao.HorarioIndisponivel;
import entidade.Animal;
import entidade.Consulta;
import entidade.Veterinario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
@Named(value = "cadastroAnimal")
@SessionScoped
public class CadastroAnimal implements Serializable {

    @Inject
    AnimalDAO animalDAO;

    @Inject
    ConsultaDAO consultaDAO;

    private Animal novoAnimal, animal;
    private String veterinario = "sim";

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
    
    public List<SelectItem> getAnimais() {
        return animalDAO.getAnimais();
    }
    public AnimalDAO getAnimalDAO() {
        return animalDAO;
    }

    public void setAnimalDAO(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public ConsultaDAO getConsultaDAO() {
        return consultaDAO;
    }

    public void setConsultaDAO(ConsultaDAO consultaDAO) {
        this.consultaDAO = consultaDAO;
    }

    public Animal getNovoAnimal() {
        return novoAnimal;
    }

    public void setNovoAnimal(Animal novoAnimal) {
        this.novoAnimal = novoAnimal;
    }

    @PostConstruct
    public void init() {
        // Neste ponto, os daos já foram injetados. Poderiam ser usados.
        novoAnimal = new Animal();
    }

    public String confirmar() {
            try {
                animalDAO.incluir(novoAnimal);
            } catch(AnimalJaCadastrado ajc) {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage("Esse Animal já existe."));
            }
        novoAnimal = new Animal();
        return null;
        }
    
    public String addvet(){
        animalDAO.incluirVet(animal,veterinario);
        return null;
    }  
}
