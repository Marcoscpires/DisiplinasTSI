/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package converters;

import dao.AnimalDAO;
import entidade.Animal;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author marco
 */
@Named(value = "animalConverter")
@ApplicationScoped
public class AnimalConverter implements Converter {

    @Inject
    AnimalDAO aBean;
   
    @Override
    public String getAsString(FacesContext context, 
            UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Animal a = (Animal) value;
        return String.valueOf( a.getId() );
    }

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
        try {
            return aBean.buscarAnimal( Integer.parseInt(value) );
        } catch(NumberFormatException nfe) { 
        }
        return null;
    }
    
}
