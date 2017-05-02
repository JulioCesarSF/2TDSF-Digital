package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CongressoDAO;
import br.com.fiap.entity.Congresso;

public class CongressoDAOImpl extends GenericDAOImpl<Congresso, Integer>
	implements CongressoDAO{

	public CongressoDAOImpl(EntityManager em) {
		super(em);
	}

}
