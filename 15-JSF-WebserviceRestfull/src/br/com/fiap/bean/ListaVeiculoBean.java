package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.repository.VeiculoRepository;
import br.com.fiap.to.VeiculoTO;

@ManagedBean
public class ListaVeiculoBean {

	private List<VeiculoTO> lista;
	
	private VeiculoRepository rep;
	
	@PostConstruct
	private void init(){
		rep = new VeiculoRepository();
		try {
			lista = rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<VeiculoTO> getLista() {
		return lista;
	}

	public void setLista(List<VeiculoTO> lista) {
		this.lista = lista;
	}
	
}
