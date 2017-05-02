package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CongressoDAO;
import br.com.fiap.dao.impl.CongressoDAOImpl;
import br.com.fiap.entity.Congresso;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CongressoBO {

	private EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();

	public void cadastrar(Congresso congresso) throws CommitErrorException {
		EntityManager em = factory.createEntityManager();
		CongressoDAO dao = new CongressoDAOImpl(em);
		try {
			dao.cadastrar(congresso);
			dao.commit();
		} catch (Exception e) {
			throw new CommitErrorException(e);
		} finally {
			em.close();
		}
	}

	public void atualizar(Congresso congresso) throws CommitErrorException {
		EntityManager em = factory.createEntityManager();
		CongressoDAO dao = new CongressoDAOImpl(em);
		try {
			dao.atualizar(congresso);
			dao.commit();
		} catch (Exception e) {
			throw new CommitErrorException(e);
		} finally {
			em.close();
		}
	}

	public List<Congresso> listar() {
		EntityManager em = factory.createEntityManager();
		CongressoDAO dao = new CongressoDAOImpl(em);
		List<Congresso> lista = dao.listar();
		em.close();
		return lista;
	}

	public Congresso buscarPorCodigo(int codigo) {
		EntityManager em = factory.createEntityManager();
		CongressoDAO dao = new CongressoDAOImpl(em);
		Congresso congresso = dao.buscar(codigo);
		em.close();
		return congresso;
	}
	
	public void remover(int codigo) throws CodigoInvalidoException,CommitErrorException{
		EntityManager em = factory.createEntityManager();
		CongressoDAO dao = new CongressoDAOImpl(em);
		try {
			dao.excluir(codigo);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
			new CommitErrorException(e);
		}catch (CodigoInvalidoException e) {
				e.printStackTrace();
				new CodigoInvalidoException(e);
		}finally {
			em.close();
		}
	}

}
