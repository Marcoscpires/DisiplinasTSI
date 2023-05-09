package br.edu.utfpr.td.cotsi.webservice.model;

import java.util.Date;

public class BoletimFurtoVeiculo 
{	
	private static int count = 0;
	private int id;
	private String identificador;
	private Date dataOcorrencia;
	private String periodoOcorrencia;
	private Parte[] partes;
	private Endereco localOcorrencia;
	private Veiculo veiculoFurtado;
	
	public BoletimFurtoVeiculo(){}
	
	public BoletimFurtoVeiculo(String identificador, Date dataOcorrencia, String periodoOcorrencia, Parte[] partes,
			Endereco localOcorrencia, Veiculo veiculoFurtado)
	{
		this.identificador = identificador;
		this.dataOcorrencia = dataOcorrencia;
		this.periodoOcorrencia = periodoOcorrencia;
		this.partes = partes;
		this.localOcorrencia = localOcorrencia;
		this.veiculoFurtado = veiculoFurtado;
		count++;
		id = count;
	}

	public String getIdentificador() 
	{
		return identificador;
	}
	
	public void setIdentificador(String identificador) 
	{
		this.identificador = identificador;
	}
	
	public Date getDataOcorrencia() 
	{
		return dataOcorrencia;
	}
	
	public void setDataOcorrencia(Date dataOcorrencia) 
	{
		this.dataOcorrencia = dataOcorrencia;
	}
	
	public String getPeriodoOcorrencia() 
	{
		return periodoOcorrencia;
	}
	
	public void setPeriodoOcorrencia(String periodoOcorrencia) 
	{
		this.periodoOcorrencia = periodoOcorrencia;
	}
	
	public Parte[] getPartes() 
	{
		return partes;
	}
	
	public void setPartes(Parte[] partes) 
	{
		this.partes = partes;
	}
	
	public Endereco getLocalOcorrencia()
	{
		return localOcorrencia;
	}
	
	public void setLocalOcorrencia(Endereco localOcorrencia) 
	{
		this.localOcorrencia = localOcorrencia;
	}
	
	public Veiculo getVeiculoFurtado() 
	{
		return veiculoFurtado;
	}
	
	public void setVeiculoFurtado(Veiculo veiculoFurtado) 
	{
		this.veiculoFurtado = veiculoFurtado;
	}
	
	
	
	
}
