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

	public void deletarPorId(int id) 
	{
		boletins.remove(boletins.stream().filter(bo -> bo.getId() == id).toList().get(0));
	}

	public void atualizar(int id, BoletimFurtoVeiculo bo) 
	{
		BoletimFurtoVeiculo boOld = boletins.stream().filter(b -> b.getId() == id).toList().get(0);
		int pos = boletins.indexOf(boOld);
		bo.setId(id);
		boletins.set(pos, bo);	
	}

}
