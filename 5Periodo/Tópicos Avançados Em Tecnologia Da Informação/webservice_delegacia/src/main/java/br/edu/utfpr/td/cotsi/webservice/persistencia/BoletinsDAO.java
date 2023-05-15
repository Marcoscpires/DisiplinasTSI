package br.edu.utfpr.td.cotsi.webservice.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Veiculo;

@Component
public class BoletinsDAO 
{
	
	List<BoletimFurtoVeiculo> boletins = new ArrayList();
	public void persistir(BoletimFurtoVeiculo bo)
	{
		boletins.add(bo);
	}
	
	public BoletimFurtoVeiculo buscarPorId(int id)
	{
		return boletins.stream().filter(t -> t.getId() == id).toList().get(0);			
	}
	
	public List<BoletimFurtoVeiculo> buscarTodos() 
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

	public List<BoletimFurtoVeiculo> buscarPorCidade(String cidade) {
		return boletins.stream().filter(t -> t.getLocalOcorrencia().getCidade().equalsIgnoreCase(cidade)).toList();
	}

	public List<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {
		return boletins.stream().filter(t -> t.getPeriodoOcorrencia().equalsIgnoreCase(periodo)).toList();
	}

	public List<Veiculo> buscarTodosVeiculos() {
		return boletins.stream().map(veiculos -> veiculos.getVeiculoFurtado()).toList();
	}

	public Veiculo buscarVeiculoPorPlaca(String placa) {
		return boletins.stream().map(veiculos -> veiculos.getVeiculoFurtado()).filter(v -> v.getEmplacamento().getPlaca().equalsIgnoreCase(placa)).toList().get(0);
	}

	public List<Veiculo> buscarVeiculoPorCor(String cor) {
		return boletins.stream().map(veiculos -> veiculos.getVeiculoFurtado()).filter(v -> v.getCor().equalsIgnoreCase(cor)).toList();
	}

	public List<Veiculo> buscarVeiculoPorTipo(String tipo) {
		return boletins.stream().map(veiculos -> veiculos.getVeiculoFurtado()).filter(v -> v.getTipoVeiculo().equals(tipo)).toList();
	}
	
	
	
	

}
