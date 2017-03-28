package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class CadastroTeste {

	public static void main(String[] args) {
		CompraTO compra = new CompraTO(0, "Fone de um ouvido só", 15);
		CompraRepository rep = new CompraRepository();
		try {
			rep.cadastrar(compra);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
