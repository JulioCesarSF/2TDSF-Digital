package br.com.fiap.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.to.CompraTO;

public class CompraRepository {

	private static final String URL = "http://localhost:8080/11-WebserviceRestfull-server-banco/rest/compra/";
	
	private Client cliente = Client.create();
	
	public List<CompraTO> listar() throws WebServiceException{
		 WebResource resource = cliente.resource(URL);
		 ClientResponse response = resource.accept(
			MediaType.APPLICATION_JSON).get(ClientResponse.class);
		 if (response.getStatus() == 200){
			 CompraTO[] compras = response.getEntity(CompraTO[].class);
			 return Arrays.asList(compras);
		 }
		 throw new WebServiceException("HTTP Status: " 
				 							+ response.getStatus());
	}
	
	public CompraTO buscar(int id) throws WebServiceException{
		WebResource resource = cliente.resource(URL + id);
		ClientResponse response = resource.accept(
			MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() == 200){
			CompraTO compra = response.getEntity(CompraTO.class);
			return compra;
		}
		throw new WebServiceException("HTTP Status: " +
											response.getStatus());
	}
	
	public void cadastrar(CompraTO compra) throws WebServiceException{
		WebResource resource = cliente.resource(URL);
		ClientResponse response = resource.type(
				MediaType.APPLICATION_JSON)
				 .post(ClientResponse.class,compra);
		 if (response.getStatus() != 201)
			 throw new WebServiceException("HTTP Status: " +
					 						response.getStatus());
	}
	
	public void atualizar(CompraTO compra) throws WebServiceException{
		WebResource resource = 
				cliente.resource(URL + compra.getCodigo());
		ClientResponse response = resource.type(
				MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,compra);
		if (response.getStatus() != 200)
			throw new WebServiceException("HTTP Status: " +
											response.getStatus());
	}
	
	public void remover(int codigo) throws WebServiceException{
		WebResource resource = cliente.resource(URL + codigo);
		ClientResponse response = resource.delete(ClientResponse.class);
		if (response.getStatus() != 204)
			throw new WebServiceException("HTTP Status: " +
											response.getStatus());
	}
	
}





