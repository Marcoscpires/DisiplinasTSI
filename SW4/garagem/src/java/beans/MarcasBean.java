package beans;

import dao.MarcaDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Named(value = "marcasBean")
@ApplicationScoped
public class MarcasBean {
        
    public MarcasBean() {
    }
    
    @Produces
    public MarcaDAO getMarcaDAO(){
        return new MarcaDAO();
    }
    
}
