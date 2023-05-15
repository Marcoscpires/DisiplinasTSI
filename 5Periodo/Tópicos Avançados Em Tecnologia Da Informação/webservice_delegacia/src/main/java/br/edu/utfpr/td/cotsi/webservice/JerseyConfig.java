package br.edu.utfpr.td.cotsi.webservice;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.cotsi.webservice.endpoint.BoletinsEndPoint;
import br.edu.utfpr.td.cotsi.webservice.endpoint.VeiculosEndPoint;

@Component
@ApplicationPath("/delegacia")
public class JerseyConfig extends ResourceConfig 
{
	
	public JerseyConfig() 
	{
		this.register(RequestContextFilter.class);
		this.register(BoletinsEndPoint.class);
		this.register(VeiculosEndPoint.class);
	}
	
}