package br.edu.utfpr.td.cotsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.persistencia.BoletinsDAO;

@Component
public class RegrasBoletins 
{
	@Autowired
	private BoletinsDAO boletinsDAO;
	
	public void cadastrar(BoletimFurtoVeiculo bo)
	{
		boletinsDAO.persistir(bo);
		
	}
	
	public BoletimFurtoVeiculo buscarPorId(int id)
	{
		return boletinsDAO.buscarPorId(id);
	}
	
	public ArrayList<BoletimFurtoVeiculo> buscarTodos()
	{
		return boletinsDAO.buscarTodos();
	}
}
