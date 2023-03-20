package br.edu.utfpr.td.tsi.banco;

import br.edu.utfpr.td.tsi.cartao.credito.GerenciadorCartaoCredito;
import br.edu.utfpr.td.tsi.clientes.GerenciadorClientes;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
		gerenciadorClientes.cadastrarCliente("Marcos");
		
		GerenciadorCartaoCredito gerenciadorCartaoCredito = new GerenciadorCartaoCredito();
		gerenciadorCartaoCredito.associarCartao("Marcos");

	}

}
