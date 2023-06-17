package br.edu.utfpr.td.cotsi.webservice.regras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.glassfish.jersey.internal.guava.ExecutionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Parte;
import br.edu.utfpr.td.cotsi.webservice.model.Veiculo;
import br.edu.utfpr.td.cotsi.webservice.persistencia.BoletinsDAO;

@Component
public class RegrasBoletinsValidadores implements RegrasBoletins {
	
	@Autowired
	private BoletinsDAO boletinsDAO;

	public void cadastrar(BoletimFurtoVeiculo bo) throws Exception {
		if(bo.getPartes() == null) {
			boletinsDAO.persistir(bo);
		}else { 
			if(validar(bo)) {
				boletinsDAO.persistir(bo);
			}else {
				throw new Exception("Email invalido");
			}
		}	
	}

	public BoletimFurtoVeiculo buscarPorId(int id) {
		return boletinsDAO.buscarPorId(id);
	}

	public List<BoletimFurtoVeiculo> buscarPorCidade(String cidade) {
		return boletinsDAO.buscarPorCidade(cidade);
	}

	public List<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {
		return boletinsDAO.buscarPorPeriodo(periodo);
	}

	public List<BoletimFurtoVeiculo> buscarTodos() {
		return boletinsDAO.buscarTodos();
	}

	public List<Veiculo> buscarTodosVeiculos() {
		return boletinsDAO.buscarTodosVeiculos();
	}

	public void deletarPorId(int id) {
		boletinsDAO.deletarPorId(id);
	}

	public void atualizar(int id, BoletimFurtoVeiculo bo) {
		boletinsDAO.atualizar(id, bo);
	}

	public Boolean validar(BoletimFurtoVeiculo bo) {
		return validarEmail(bo);
	}

	public Veiculo buscarVeiculoPorPlaca(String placa) {
		return boletinsDAO.buscarVeiculoPorPlaca(placa);
	}

	public List<Veiculo> buscarVeiculoPorCor(String cor) {
		return boletinsDAO.buscarVeiculoPorCor(cor);
	}

	public List<Veiculo> buscarVeiculoPorTipo(String tipo) {
		return boletinsDAO.buscarVeiculoPorTipo(tipo);
	}

	public Boolean validarEmail(BoletimFurtoVeiculo bo) {
		Parte[] partes = bo.getPartes();
		String email;
		Boolean valido = false;
		for (int i = 0; i < partes.length; i++) {
			email = partes[i].getEmail();
			if((email.indexOf('@') > 0) && (email.indexOf('.') >email.indexOf('@')+1)) {
				valido = true;
			}else {
				valido = false;
			}
		}
		return valido;
	}
}