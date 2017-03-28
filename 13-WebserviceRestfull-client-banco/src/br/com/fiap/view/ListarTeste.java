package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class ListarTeste {

	public static void main(String[] args) {
		CompraRepository rep = new CompraRepository();
		try {
			List<CompraTO> lista = rep.listar();
			for (CompraTO compraTO : lista) {
				System.out.println(compraTO.getDescricao());
				System.out.println(compraTO.getValor());
			}
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}





