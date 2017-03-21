package br.com.fiap.view;

import br.com.fiap.repository.VeiculoRepository;
import br.com.fiap.to.VeiculoTO;

public class CadastroTeste {

	public static void main(String[] args) {
		
		VeiculoRepository rep = new VeiculoRepository();
		VeiculoTO veiculo = new VeiculoTO(0, "Fusca", "Volks", 10);
		
		try {
			rep.cadastrar(veiculo);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
