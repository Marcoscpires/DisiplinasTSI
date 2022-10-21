package dao;

import entidade.Animal;
import entidade.Consulta;
import java.io.Serializable;
import java.util.ArrayList;

public class ConsultaDAO implements Serializable {
    private ArrayList<Consulta> consultas;
    
    public ConsultaDAO() {
        consultas = new ArrayList<>();
    }
    
    public void incluir(Consulta c) throws ConsultaJaMarcada {
        if (consultas.contains(c)) {
            throw new ConsultaJaMarcada();
        }
        consultas.add(c);
    }
    
//    public ArrayList<Consulta> buscar(Animal marcaFiltro, int anoInicio, int anoFim) {
//        ArrayList<Veiculo> filtrados = new ArrayList<>();
//        if (marcaFiltro == null) {
//            filtrados.addAll(consultas );
//        } else {
//            for (Veiculo v : consultas) {
//                if (v.getModelo().getMarca().equals(marcaFiltro)) {
//                    filtrados.add(v);
//                }
//            }
//        }
//        if (anoInicio > 0 && anoFim > 0) {
//            ArrayList<Veiculo> filtroAnos = new ArrayList<>();
//            for (Veiculo v : filtrados) {
//                if (v.getAnoFabricacao() >= anoInicio && v.getAnoFabricacao() <= anoFim) {
//                    filtroAnos.add(v);
//                }
//            }
//            filtrados = filtroAnos;
//        }
//        return filtrados;
//    }
    
    public void remover(Consulta c) {
        consultas.remove(c);
    }
    
}
