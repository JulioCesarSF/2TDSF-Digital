package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.CompraRepository;

public class RemoveTeste {

	public static void main(String[] args) {
		CompraRepository rep = new CompraRepository();
		try {
			rep.remover(1);
			System.out.println("Removido!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
