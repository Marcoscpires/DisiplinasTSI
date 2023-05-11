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
import javax.ws.rs.core.Response.Status;

import br.edu.utfpr.td.cotsi.webservice.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.cotsi.webservice.model.Parte;
import br.edu.utfpr.td.cotsi.webservice.regras.RegrasBoletins;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("boletins")
public class BoletinsEndPoint 
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
	@Path("{id}")
	public Response buscarBoletimPorId(@PathParam("id") int id)
	{
		return Response.ok(regrasBoletins.buscarPorId(id)).build();
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
	@Path("{id}")
	public Response deletarPorId(@PathParam("id") int id) 
	{
		try 
		{
			regrasBoletins.deletarPorId(id);
			return Response.ok("Boletim com id "+ id + " deletado.").build();
		}catch (Exception e) 
		{
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizarPorId(@PathParam("id") int id, BoletimFurtoVeiculo bo)
	{
		try
		{
			regrasBoletins.atualizar(id, bo);
			return Response.ok("Boletim com id "+ id + " atualizado").build();
		}catch (Exception e) 
		{
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho3")
	public Response teste3(@QueryParam("var2") String x){
		return Response.ok(String.format("%s foi informado como queryParam", x)).build();
	}
	
	@PathParam("id") 
	private int id;
	
	@QueryParam("var2") 
	private String y;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho4")	
	public Response teste4(){
		return Response.ok(String.format("%s = pathParan %s = queryParam ", id, y)).build();
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

