package remotos;

import java.util.List;
import javax.ejb.*;
import modelo.Cliente;

@Remote
public interface ServicosCliente {
    public void inserir(Cliente cliente);
    public void remover(Cliente cliente);
    public List<Cliente> filtrar(String filtro);
    
    
}
