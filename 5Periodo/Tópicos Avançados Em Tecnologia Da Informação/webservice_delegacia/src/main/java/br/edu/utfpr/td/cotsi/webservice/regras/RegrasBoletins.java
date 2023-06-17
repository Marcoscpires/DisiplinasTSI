package br.edu.utfpr.td.cotsi.webservice.regras;

import java.util.List;

import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Veiculo;

public interface RegrasBoletins {
	
	public void cadastrar(BoletimFurtoVeiculo bo) throws Exception;
	
	public BoletimFurtoVeiculo buscarPorId(int id);
	
	public List<BoletimFurtoVeiculo> buscarPorCidade(String cidade);
	
	public List<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo);
	
	
	public List<BoletimFurtoVeiculo> buscarTodos();

	public void deletarPorId(int id);

	public void atualizar(int id, BoletimFurtoVeiculo bo);
	
	public Boolean validar(BoletimFurtoVeiculo bo);

	public List<Veiculo> buscarTodosVeiculos();

	public Veiculo buscarVeiculoPorPlaca(String placa);

	public List<Veiculo> buscarVeiculoPorCor(String cor);

	public List<Veiculo> buscarVeiculoPorTipo(String tipo);

}
