package br.edu.utfpr.td.cotsi.webservice.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Parte;
import br.edu.utfpr.td.cotsi.webservice.regras.RegrasBoletins;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("boletins")
public class CadastroDeBoletins 
{
	
	@Autowired
	private RegrasBoletins regrasBoletins;
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarBoletins() {
		return Response.ok(regrasBoletins.buscarTodos()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{var1}")
	public Response buscarBoletim(@PathParam("var1") int x)
	{
		BoletimFurtoVeiculo bo = regrasBoletins.buscarPorId(x);
		return Response.ok(bo).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletinOcorrencia(BoletimFurtoVeiculo bo) 
	{
		regrasBoletins.cadastrar(bo);
		return Response.ok(bo).build();
		
	}
	
	@DELETE
	@Path("deletar/{var1}")
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho3")
	public Response teste3(@QueryParam("var2") String x){
		return Response.ok(String.format("%s foi informado como queryParam", x)).build();
	}
	
	@PathParam("var1") 
	private int x;
	
	@QueryParam("var2") 
	private String y;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho4")	
	public Response teste4(){
		return Response.ok(String.format("%s = pathParan %s = queryParam ", x, y)).build();
	}
	
	@GET
	@Path("/carregarCliente")
	@Produces({MediaType.APPLICATION_JSON})
	public Response carregarCliente() {
		Parte parte = new Parte();
		parte.setEmail("joao@silva.com");
		parte.setNome("Joao da Silva");
		
		return Response.ok(parte).build();
	}
	
}

