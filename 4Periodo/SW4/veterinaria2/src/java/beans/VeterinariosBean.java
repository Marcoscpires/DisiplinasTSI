
package beans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import model.Consulta;
import model.TipoAnimal;
import model.Veterinario;


@Named(value = "veterinariosBean")
@ApplicationScoped
public class VeterinariosBean {

    private Veterinario veterinario;
    private List<Veterinario> veterinarios;

    public List<Veterinario> getVeterinarios() {
        if (veterinarios == null) {
            try {
                Query consulta = em.createQuery(
                        "select v from Veterinario v ",
                        Veterinario.class);
                veterinarios = consulta.getResultList();
            } catch (Throwable t) {
                t.printStackTrace();
                veterinarios = new LinkedList<Veterinario>();
            }
        }
        return veterinarios;
    }     

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }
    
    @PersistenceContext
    EntityManager em;
    
    @Resource
    UserTransaction utx;
    
    public VeterinariosBean() {
        veterinario = new Veterinario();
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    public String salvar() {
        try {
            utx.begin();
            em.persist(veterinario);
            utx.commit();
            veterinario = new Veterinario();
            veterinarios = null;
        } catch (Throwable t) {
            t.printStackTrace();
            try { utx.rollback(); } catch(Throwable t2) { }
        }
        return null;
    }

}
