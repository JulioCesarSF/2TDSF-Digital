package br.com.fiap.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;

import br.com.fiap.to.ProdutoTO;

public class EstoqueBO {

	private Map<Integer, ProdutoTO> banco;
	
	public EstoqueBO() {
		banco = new HashMap<>();
		//Simular o banco de dados...
		banco.put(401, new ProdutoTO(401, "Camisa Branca Masculina Manga Curta", 10, 500));
		banco.put(402, new ProdutoTO(402, "Camisa Rosa Feminina Manga Longa",100,10));
	}
	
	public ProdutoTO consultarProduto(int codigo) throws AxisFault{
		ProdutoTO prod = banco.get(codigo);
		if (prod == null)
			throw new AxisFault("Produto não cadastrado");
		return prod;
	}
	
	public Collection<ProdutoTO> listar(){
		return banco.values();
	}
	
}





