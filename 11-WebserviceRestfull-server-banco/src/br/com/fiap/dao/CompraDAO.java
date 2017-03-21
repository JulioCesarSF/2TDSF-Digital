package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Compra;

public interface CompraDAO extends GenericDAO<Compra, Integer>{

	List<Compra> listar();
	
}