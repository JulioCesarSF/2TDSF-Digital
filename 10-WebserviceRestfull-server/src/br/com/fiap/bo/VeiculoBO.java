package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.fiap.to.VeiculoTO;

public class VeiculoBO {

	private static HashMap<Integer,VeiculoTO> banco = new HashMap<>();
	
	private static int sequence = 3;
	
	static{
		banco.put(1, new VeiculoTO(1, "Azera", "Hyundai", 50000));
		banco.put(2, new VeiculoTO(2, "Moby", "FIAT", 30000));
		banco.put(3, new VeiculoTO(3, "Focus", "FORD", 70000));
	}
	
	public void cadastrar(VeiculoTO veiculo){
		veiculo.setCodigo(++sequence);
		banco.put(sequence, veiculo);
	}
	
	public VeiculoTO buscar(int id){
		return banco.get(id);
	}
	
	public List<VeiculoTO> listar(){
		return new ArrayList<>(banco.values());
	}
	
	public void alterar(VeiculoTO veiculo){
		banco.put(veiculo.getCodigo(), veiculo);
	}
	
	public void remover(int codigo){
		banco.remove(codigo);
	}
	
}
