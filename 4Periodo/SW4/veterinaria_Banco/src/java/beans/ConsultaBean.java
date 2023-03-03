package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
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
    
    public List<Consulta>getConsultas(){
        if(consultas == null){
            try { 
                Query query = em.createQuery(
                        "select c from Consulta c"
                +"order by c.id", 
                        Consulta.class);
                consultas = query.getResultList();
            }catch(Throwable t){
                t.printStackTrace();
                consultas = new LinkedList<Consulta>();
            }
        }
        return consultas;
    }

    // para filtar os veterinários quando o usuário alterar o tipo de animal a consultar
    private TipoAnimal tipoAnimal;

    public ConsultaBean() {
        consulta = new Consulta();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String salvar() {
        try {
        ctx.begin();
        em.persist(consulta);
        ctx.commit();
        consulta = new Consulta();
        consultas = null;
        }catch(Exception ex){
            ex.printStackTrace();
            try {
                ctx.rollback();
            }catch (Exception ex2){
            }
        }
        return null;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public List<SelectItem> getVetsPorTipo() {
        if (tipoAnimal != null) {
            List<Veterinario> vets = em.createQuery("select v from "
                    + " Veterinario v where v.especialidade = :x")
                    .setParameter("x", tipoAnimal)
                    .getResultList();
            List<SelectItem> vetsPorTipo = new LinkedList<>();
            for (Veterinario v : vets) {
                vetsPorTipo.add(new SelectItem(v, v.getNome()));
            }
            return vetsPorTipo;
        } else {
            return new LinkedList<>();
        }
    }
}
