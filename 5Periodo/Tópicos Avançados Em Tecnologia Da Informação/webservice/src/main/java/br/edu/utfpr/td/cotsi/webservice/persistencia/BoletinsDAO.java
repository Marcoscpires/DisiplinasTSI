package br.edu.utfpr.td.cotsi.webservice.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.endpoint.CadastroDeBoletins;
import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;

@Component
public class BoletinsDAO 
{
	
	ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList();
	public void persistir(BoletimFurtoVeiculo bo) {
		boletins.add(bo);
		
	}

}
