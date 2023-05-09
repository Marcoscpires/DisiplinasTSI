package br.edu.utfpr.td.cotsi.webservice.regras;

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
}
