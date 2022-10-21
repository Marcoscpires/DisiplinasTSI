/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package converters;

import dao.AnimalDAO;
import entidade.Veterinario;
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
@Named(value = "veterinarioConverter")
@ApplicationScoped
public class VeterinarioConverter implements Converter {

    @Inject
    AnimalDAO animalBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int id = Integer.parseInt( value );
            return animalBean.buscarVeterinario( id );
        } catch(NumberFormatException ex) { }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value == null) {
           return null;
       }
       Veterinario mod = (Veterinario) value;
       return String.valueOf( mod.getId() );
    }
    
}
