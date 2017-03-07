package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.PratoDAO;
import br.com.fiap.dao.impl.PratoDAOImpl;
import br.com.fiap.entity.Prato;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PratoBO {

	public Prato buscar(int id){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PratoDAO dao = new PratoDAOImpl(em);
		Prato prato = dao.buscar(id);
		em.close();
		return prato;
	}
	
	public void cadastrar(Prato prato) throws AxisFault {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		PratoDAO dao = new PratoDAOImpl(em);
		try {
			dao.cadastrar(prato);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
			throw new AxisFault("Erro"); 
		}finally {
			em.close();
		}
	}
	
}
