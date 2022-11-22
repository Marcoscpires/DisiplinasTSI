package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelo.Cliente;
import remotos.ServicosCliente;

@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    Cliente cliente;

    @EJB(lookup = "java:global/EJBApp1/EJBApp1-ejb/ClienteEJB!remotos.ServicosCliente" )
    ServicosCliente dao;

    public ClienteBean() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente c) {
        cliente = c;
    }

    public String confirmar() {
        dao.inserir(cliente);
        cliente = new Cliente();
        return null;
    }
    
    public List<Cliente> getListaClientes(){
        return dao.filtrar(null);
    }

}
