package br.edu.utfpr.td.cotsi.webservice.regras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public void cadastrar(BoletimFurtoVeiculo bo) {
		validar(bo);
		boletinsDAO.persistir(bo);

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
		Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
		Parte[] partes = bo.getPartes();
		for (int i = 0; i < partes.length; i++) {
			Matcher corresponde = pattern.matcher(partes[i].getEmail());
			if (!corresponde.matches()) {
				return false;
			}
		}
		return true;

	}

}
