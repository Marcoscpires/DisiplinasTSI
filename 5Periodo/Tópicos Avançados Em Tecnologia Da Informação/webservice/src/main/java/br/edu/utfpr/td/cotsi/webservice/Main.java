package br.edu.utfpr.td.cotsi.webservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Emplacamento;
import br.edu.utfpr.td.cotsi.webservice.model.Endereco;
import br.edu.utfpr.td.cotsi.webservice.model.Veiculo;
import br.edu.utfpr.td.cotsi.webservice.regras.RegrasBoletins;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.cotsi.webservice")
public class Main {

	@Autowired
	private RegrasBoletins regrasBoletins;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

	@PostConstruct
	public void init() throws IOException, ParseException {
		System.out.println("Inicio do programa");

		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\TI\\Desktop\\DisiplinasTSI\\5Periodo\\Tópicos Avançados Em Tecnologia Da Informação\\webservice\\src\\main\\java\\br\\edu\\utfpr\\td\\cotsi\\webservice\\furtos.csv"));
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String linha = "";
		while ((linha = br.readLine()) != null) {
			BoletimFurtoVeiculo bo = new BoletimFurtoVeiculo();
			Emplacamento placa = new Emplacamento();
			Veiculo veiculo = new Veiculo();
			Endereco endereco = new Endereco();
			String[] dados = linha.split(";");
			if (dados.length >= 50) {
				placa.setPlaca(dados[44]);
				placa.setCidade(dados[46]);
				placa.setEstado(dados[45]);
				try {
					veiculo.setAnoFabricacao(Integer.parseInt(dados[49]));
				} catch (NumberFormatException numEx) {
					veiculo.setAnoFabricacao(0);
				}
				veiculo.setCor(dados[47]);
				veiculo.setEmplacamento(placa);
				veiculo.setMarca(dados[48]);
				try {
					veiculo.setTipoVeiculo(dados[51]);
				} catch (Exception e) {
					veiculo.setTipoVeiculo(null);
				}
				endereco.setBairro(dados[15]);
				endereco.setCidade(dados[16]);
				endereco.setEstado(dados[17]);
				endereco.setLogradouro(dados[13]);
				try {
					endereco.setNumero(Integer.parseInt(dados[12]));
				} catch (NumberFormatException numEx) {
					endereco.setNumero(0);
				}
				try {
					bo.setDataOcorrencia(formatador.parse(dados[5]));
				} catch (ParseException pe) {
					bo.setDataOcorrencia(null);
				}
				bo.setIdentificador(dados[1]);
				bo.setLocalOcorrencia(endereco);
				bo.setPeriodoOcorrencia(dados[7]);
				bo.setVeiculoFurtado(veiculo);
				regrasBoletins.cadastrar(bo);
			}
		}
		br.close();

	}

}
