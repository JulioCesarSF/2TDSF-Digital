package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.VeiculoTO;

//Recupera os dados do banco ou webservice (como se fosse o DAO)

public class VeiculoRepository {

	private Client client = Client.create();

	public void atualizar(VeiculoTO veiculo) throws Exception{
		WebResource resource = client.resource("http://localhost:8080/"
			+ "10-WebserviceRestfull-server/rest/veiculo/"+ veiculo.getCodigo());
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,veiculo);
		
		if (response.getStatus() != 200)
			throw new Exception("Erro " + response.getStatus());
	}
	
	public void remover(int codigo) throws Exception{
		WebResource resource = client.resource("http://localhost:8080/"
				+ "10-WebserviceRestfull-server/rest/veiculo/"+ codigo);
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204)
			throw new Exception("Erro: " + response.getStatus());
	}
	
	public void cadastrar(VeiculoTO veiculo) throws Exception{
		
		WebResource resource = client.resource("http://localhost:8080/10-WebserviceRestfull-server/rest/veiculo");
		ClientResponse response = resource.type(
			MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,veiculo);
		
		if (response.getStatus() != 201)
			throw new Exception("Erro " + response.getStatus());
	}
	
	public VeiculoTO buscar(int id) throws Exception{
		WebResource resource = client.resource(""
				+ "http://localhost:8080/10-WebserviceRestfull"
				+ "-server/rest/veiculo/"+id);
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		if (response.getStatus() == 200){
			VeiculoTO veiculo = response
					.getEntity(VeiculoTO.class);
			return veiculo;
		}
		
		throw new Exception("Erro: " + response.getStatus());
	}
	
	public List<VeiculoTO> listar() throws Exception {
		WebResource resource = client.resource("http://localhost:8080/10-WebserviceRestfull-server/rest/veiculo");

		// Chama o webservice
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// Valida o HTTP Status da resposta
		if (response.getStatus() == 200) {
			// Recuperar a lista de veiculos do webservice
			VeiculoTO[] array = response.getEntity(VeiculoTO[].class);
			return Arrays.asList(array);
		} 
		
		throw new Exception("Erro " + response.getStatus());
	}

}
