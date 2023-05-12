package br.edu.utfpr.td.cotsi.webservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Emplacamento;
import br.edu.utfpr.td.cotsi.webservice.model.Endereco;
import br.edu.utfpr.td.cotsi.webservice.model.Veiculo;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.cotsi.webservice")
public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(Main.class, args);
		BufferedReader br = new BufferedReader(new FileReader("furtos.csv"));
    	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    	BoletimFurtoVeiculo bo = new BoletimFurtoVeiculo();
    	Emplacamento placa = new Emplacamento();
    	Veiculo veiculo = new Veiculo();
    	Endereco endereco = new Endereco();	  
	    String linha;
	    while ((linha = br.readLine()) != null) 
	    {
	    	System.out.println(linha);
	    	
//	        String[] dados = linha.split("\t");
//	        placa.setPlaca(dados[44]);
//	        placa.setCidade(dados[46]);
//	        placa.setEstado(dados[45]);
//	        veiculo.setAnoFabricacao(Integer.parseInt(dados[49]));
//	        veiculo.setCor(dados[47]);
//	        veiculo.setEmplacamento(placa);
//	        veiculo.setMarca(dados[48]);
//	        veiculo.setTipoVeiculo(dados[51]);
//	        endereco.setBairro(dados[15]);
//	        endereco.setCidade(dados[16]);
//	        endereco.setEstado(dados[17]);
//	        endereco.setLogradouro(dados[13]);
//	        endereco.setNumero(Integer.parseInt(dados[12]));
//	        bo.setDataOcorrencia(formatador.parse(dados[5]));
//	        bo.setIdentificador(dados[1]);
//	        bo.setLocalOcorrencia(endereco);
//	        bo.setPeriodoOcorrencia(dados[7]);
//	        bo.setVeiculoFurtado(veiculo);
//	        regrasBoletins.cadastrar(bo);
	    }
	    br.close();

	}
	
	@PostConstruct
	public void init() throws IOException 
	{
		System.out.println("Inicio do programa");
		 
    	
	}
	
}
