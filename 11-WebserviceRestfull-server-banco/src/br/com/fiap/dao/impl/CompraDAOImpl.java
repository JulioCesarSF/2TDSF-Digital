package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CompraDAO;
import br.com.fiap.entity.Compra;

public class CompraDAOImpl 
				extends GenericDAOImpl<Compra, Integer>
									implements CompraDAO{

	public CompraDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Compra> listar() {
		return em.createQuery("from Compra",Compra.class)
										.getResultList();
	}

}





