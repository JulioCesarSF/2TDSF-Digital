package br.com.fiap.view;

import br.com.fiap.repository.VeiculoRepository;
import br.com.fiap.to.VeiculoTO;

public class AtualizaTeste {

	public static void main(String[] args) {
		VeiculoRepository rep = new VeiculoRepository();
		VeiculoTO veiculo = new VeiculoTO(1, "Opala", "Volks", 500);
		try {
			rep.atualizar(veiculo);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
