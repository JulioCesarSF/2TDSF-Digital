package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.VeiculoRepository;
import br.com.fiap.to.VeiculoTO;

public class BuscaTeste {

	public static void main(String[] args) {
		
		VeiculoRepository rep = new VeiculoRepository();
		
		try {
			List<VeiculoTO> lista = rep.listar();
			for (VeiculoTO veiculoTO : lista) {
				System.out.println(veiculoTO.getMarca());
				System.out.println(veiculoTO.getModelo());
				System.out.println(veiculoTO.getPreco());
				System.out.println("***********");
			}
			
			//Buscar por id
			System.out.println("BUSCAR POR ID:");
			VeiculoTO veiculo = rep.buscar(2);
			System.out.println(veiculo.getMarca());
			System.out.println(veiculo.getModelo());
			System.out.println(veiculo.getPreco());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
