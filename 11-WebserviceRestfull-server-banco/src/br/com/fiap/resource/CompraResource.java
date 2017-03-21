package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

import br.com.fiap.dao.CompraDAO;
import br.com.fiap.dao.impl.CompraDAOImpl;
import br.com.fiap.entity.Compra;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/compra")
public class CompraResource {

	private EntityManagerFactory fabrica;
	
	public CompraResource() {
		fabrica = EntityManagerFactorySingleton.getInstance();
	}
	
	//rest/compra/{id} GET
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Compra buscar(@PathParam("codigo") int id){
		EntityManager em = fabrica.createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);
		Compra compra = dao.buscar(id);
		em.close();
		return compra;
	}
	
	//rest/compra GET
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compra> listar(){
		EntityManager em = fabrica.createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);
		List<Compra> lista = dao.listar();
		em.close();
		return lista;
	}
	
	//rest/compra/{codigo} PUT
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Compra compra, 
								@PathParam("id") int codigo){
		EntityManager em = fabrica.createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);
		compra.setCodigo(codigo);
		try {
			dao.atualizar(compra);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return Response.ok().build();
	}
	
	//rest/compra/{codigo} DELETE
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int codigo){
		EntityManager em = fabrica.createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);
		try{
			dao.excluir(codigo);
			dao.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
	}
	
	//rest/compra POST
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //Recebe JSON
	public Response cadastrar(Compra compra, 
				@Context UriInfo uriInfo){
		//Cria o DAO
		EntityManager em = fabrica.createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);
		//Utiliza o DAO para cadastrar
		try {
			dao.cadastrar(compra);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		//Retorna a URL e o HTTP status 201 (created)
		UriBuilder url = UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(compra.getCodigo()));
		return Response.created(url.build()).build();
	}
	
}








