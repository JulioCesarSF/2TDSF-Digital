package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.VeiculoBO;
import br.com.fiap.to.VeiculoTO;

@Path("/veiculo")
public class VeiculoResource {
	
	private VeiculoBO bo = new VeiculoBO();
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id){
		bo.remover(id);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(VeiculoTO veiculo,
			 @PathParam("id") int codigo){
		veiculo.setCodigo(codigo);
		bo.alterar(veiculo);
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(VeiculoTO veiculo, @Context UriInfo uri){
		bo.cadastrar(veiculo); //Cadastra o veiculo
		UriBuilder builder = UriBuilder.fromUri(uri.getAbsolutePath());
		builder.path(veiculo.getCodigo()+"");
		//Retorna o status 201 (created) com o link para acessar o veiculo
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VeiculoTO> listar(){
		return bo.listar();
	}
	
	@GET
	@Path("/{churros}")
	@Produces(MediaType.APPLICATION_JSON)
	public VeiculoTO buscar(@PathParam("churros") int id){
		return bo.buscar(id);
	}
	
}






