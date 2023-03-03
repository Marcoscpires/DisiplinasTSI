package ejbs;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import modelo.Cliente;

@Singleton
public class CadClientes {

    private List<Cliente> clientes = new LinkedList<Cliente>();

    public void inserir(Cliente c) {
        if (!clientes.contains(c)) {
            clientes.add(c);
        }
    }

    public void remover(Cliente c) {
        clientes.remove(c);
    }

    @Lock(LockType.READ)
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> resp = new LinkedList<>();
        if (nome == null || nome.trim().isEmpty()) {
            resp.addAll(clientes);
        } else {
            for (Cliente c : clientes) {
                if (c.getNome().contains(nome)) {
                    resp.add(c);
                }
            }
        }
        return resp;
    }
}
