package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class AtualizarTeste {

	public static void main(String[] args) {
		CompraTO compra = new CompraTO(1, "Fone", 50);
		CompraRepository rep = new CompraRepository();
		
		try {
			rep.atualizar(compra);
			System.out.println("Atualizado");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
	}
	
}




