package br.com.fiap.view;

import br.com.fiap.repository.VeiculoRepository;

public class RemoveTeste {

	public static void main(String[] args) {
		VeiculoRepository rep = new VeiculoRepository();
		try {
			rep.remover(1);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
