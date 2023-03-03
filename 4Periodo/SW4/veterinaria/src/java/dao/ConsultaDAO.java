package dao;

import entidade.Consulta;
import java.io.Serializable;
import java.util.ArrayList;

public class ConsultaDAO implements Serializable {
    
    private ArrayList<Consulta> consultas;
    
    public ConsultaDAO() {
        consultas = new ArrayList<>();
    }
    
    public void incluir(Consulta c) throws HorarioIndisponivel {
        for (Consulta con : consultas) {
            if (c.equals(c)) {
                if (con.getVeterinario().getId() == c.getVeterinario().getId()) {
                    throw new HorarioIndisponivel();
                }
            }
        }
        consultas.add(c);
    }
    
    public ArrayList<Consulta> buscar() {
        ArrayList<Consulta> filtrados = new ArrayList<>();
        for(Consulta c : consultas){
            
        filtrados.add(c);
        
        }
        return filtrados;
    }
    
    public ArrayList<Consulta> limpar(){
        ArrayList<Consulta> filtrados = new ArrayList<>();
        filtrados.addAll(consultas);
        return filtrados;
    }
    
    public void remover(Consulta c) {
        consultas.remove(c);
    }
    
}
