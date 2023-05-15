package br.edu.utfpr.td.cotsi.webservice.endpoint;

import java.io.IOException;
import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.cotsi.webservice.regras.RegrasBoletins;

@Component
@Path("veiculos")
public class VeiculosEndPoint {

	@Autowired
	private RegrasBoletins regrasBoletins;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarVeiculos() throws IOException, ParseException {
		return Response.ok(regrasBoletins.buscarTodosVeiculos()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("placa/{placa}")
	public Response buscarVeiculoPorPlaca(@PathParam("placa") String placa) {
		try {
			return Response.ok(regrasBoletins.buscarVeiculoPorPlaca(placa)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cor/{cor}")
	public Response buscarVeiculoPorCor(@PathParam("cor") String cor) {
		try {
			return Response.ok(regrasBoletins.buscarVeiculoPorCor(cor)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("tipo/{tipo}")
	public Response buscarVeiculoPorTipo(@PathParam("tipo") String tipo) {
		try {
			return Response.ok(regrasBoletins.buscarVeiculoPorTipo(tipo)).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

	}
	
	
}
