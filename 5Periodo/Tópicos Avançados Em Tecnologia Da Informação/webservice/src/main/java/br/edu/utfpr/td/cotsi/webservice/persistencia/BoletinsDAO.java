package br.edu.utfpr.td.cotsi.webservice.persistencia;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;

@Component
public class BoletinsDAO 
{
	
	ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList();
	public void persistir(BoletimFurtoVeiculo bo)
	{
		boletins.add(bo);
	}
	
	public BoletimFurtoVeiculo buscarPorId(int id)
	{
		return boletins.stream().filter(t -> t.getId() == id).toList().get(0);			
	}
	
	public ArrayList<BoletimFurtoVeiculo> buscarTodos() 
	{
		return boletins;
	}

}
