package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.fiap.repository.VeiculoRepository;
import br.com.fiap.to.VeiculoTO;

@ManagedBean
public class VeiculoBean {
	
	private int codigo;
	private VeiculoTO veiculo;
	private VeiculoRepository rep;
	
	//Método para inicializar os objetos do ManagedBean
	@PostConstruct
	private void init(){
		veiculo = new VeiculoTO();
		rep = new VeiculoRepository();
	}
	
	public void buscar(){
		try {
			veiculo = rep.buscar(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método para o clique do botão da tela
	public String cadastrar(){
		try {
			rep.cadastrar(veiculo);			
			System.out.println("Cadastrado");
			//Mensagem de sucesso
			FacesMessage msg = new FacesMessage("Veiculo cadastrado!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "cadastro-veiculo";
		}
		return "lista-veiculo";
	}

	public VeiculoTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoTO veiculo) {
		this.veiculo = veiculo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
