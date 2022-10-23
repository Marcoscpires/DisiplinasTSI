/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AnimalDAO;
import dao.ConsultaDAO;
import entidade.Animal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    
    private Animal novoAnimal;
    
     public void init() {        
        // Neste ponto, os daos já foram injetados. Poderiam ser usados.
        novoAnimal = new Animal();
    }

    
    public CadastroAnimal() {
    }
    
}
