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

import java.io.IOException;
import java.text.ParseException;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("boletins")
public class BoletinsEndPoint {

	@Autowired
	private RegrasBoletins regrasBoletins;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarBoletins() throws IOException, ParseException {
		return Response.ok(regrasBoletins.buscarTodos()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("id/{id}")
	public Response buscarBoletimPorId(@PathParam("id") int id) {
		try {
			return Response.ok(regrasBoletins.buscarPorId(id)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cidade/{cidade}")
	public Response buscarBoletimPorCidade(@PathParam("cidade") String cidade) {
		try {
			return Response.ok(regrasBoletins.buscarPorCidade(cidade)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("periodo/{periodo}")
	public Response buscarBoletimPorPeriodo(@PathParam("periodo") String periodo) {
		try {
			return Response.ok(regrasBoletins.buscarPorPeriodo(periodo)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletinOcorrencia(BoletimFurtoVeiculo bo) {
		regrasBoletins.cadastrar(bo);
		return Response.ok(bo).build();

	}

	@DELETE
	@Path("{id}")
	public Response deletarPorId(@PathParam("id") int id) {
		try {
			regrasBoletins.deletarPorId(id);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizarPorId(@PathParam("id") int id, BoletimFurtoVeiculo bo) {
		try {
			regrasBoletins.atualizar(id, bo);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}



}
