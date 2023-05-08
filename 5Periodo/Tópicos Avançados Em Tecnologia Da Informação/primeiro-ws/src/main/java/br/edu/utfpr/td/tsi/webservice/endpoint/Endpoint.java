package br.edu.utfpr.td.tsi.webservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.PessoaDAOEmMemoria;
import br.edu.utfpr.td.tsi.webservice.modelo.Pessoa;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasPessoa;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasPessoaPR;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("endpoint")
@Component
public class Endpoint {
	
	@Autowired
	private RegrasPessoa regrasPessoa;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarTexto() {
		
		//busquei no banco de dados uma informacao
		Pessoa p = new Pessoa("joao", "email", "123");
		p.setIdade(44);
		
		return Response.ok(p).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarPessoa(Pessoa p) {
		
		regrasPessoa.cadastrar(p);
		return Response.ok(p).build();
		
	}
	
	
	

}
