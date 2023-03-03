package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import model.Consulta;
import model.TipoAnimal;
import model.Veterinario;

@Named(value = "consultaBean")
@SessionScoped
public class ConsultaBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction ctx;

    private Consulta consulta;
    private List<Consulta> consultas;
    private LinkedList<SelectItem> vetsPorTipo = null;
    private TipoAnimal tipoAnimal;
    
    public ConsultaBean() {
        consulta = new Consulta();
    }
    
    public List<Consulta> getConsultas() {
        if (consultas == null) {
            try {
                Query consulta = em.createQuery(
                        "select c from Consulta c "                                
                        + "order by c",
                        Consulta.class);
                consultas = consulta.getResultList();
            } catch (Throwable t) {
                t.printStackTrace();
                consultas = new LinkedList<Consulta>();
            }
        }
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
     public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    
    public List<SelectItem> getVetsPorTipo() {
            List<Veterinario> vets = em.createQuery("select v from "
                    + " Veterinario v where v.especialidade = :x")
                    .setParameter("x", tipoAnimal)
                    .getResultList();
            vetsPorTipo = new LinkedList<>();
            vetsPorTipo.add(new SelectItem(null, "Selecion um Animal"));
            for (Veterinario v : vets) {
                vetsPorTipo.add(new SelectItem(v, v.getNome()));
            }
        return vetsPorTipo;
    }
    

    public String cancelar() {
        consulta = new Consulta();
        return null;
    }

    public void remover(Consulta c) {
        try {
            ctx.begin();
            c = em.merge(c);
            em.remove(c);
            ctx.commit();
            consultas.remove(c);
        } catch (Throwable t) {
            t.printStackTrace();
            try {
                ctx.rollback();
            } catch (Exception ex2) {
            }
        }
    }

    public String salvar() {

        try {
            marcarConsulta(consulta);
        } catch (ConsultaJaMarcada cjm) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Esse Veterinario já tem uma consulta marcada nesse horario"));
        }
        return null;
    }
    
    public void marcarConsulta(Consulta c) throws ConsultaJaMarcada {
        for (Consulta con : consultas) {
            if (con.equals(c)) {
                if (con.getVeterinario().getId() == c.getVeterinario().getId()) {
                    throw new ConsultaJaMarcada();
                }
            }
        }
        try {
            ctx.begin();
            em.persist(c);
            ctx.commit();
            consulta = new Consulta();
            consultas = null;
        } catch (Throwable t) {
            t.printStackTrace();
            try {
                ctx.rollback();
            } catch (Throwable t2) {
            }
        }
        consulta = new Consulta();
    }
    
   

}
