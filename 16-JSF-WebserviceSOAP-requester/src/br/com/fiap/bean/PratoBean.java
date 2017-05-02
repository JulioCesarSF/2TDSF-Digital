package br.com.fiap.bean;

import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.PratoBOStub;
import br.com.fiap.bo.PratoBOStub.Buscar;
import br.com.fiap.bo.PratoBOStub.BuscarResponse;
import br.com.fiap.bo.PratoBOStub.Cadastrar;
import br.com.fiap.bo.PratoBOStub.Prato;
import br.com.fiap.to.PratoTO;

@ManagedBean
public class PratoBean {

	private PratoTO prato;

	private Prato p;
	private int codigo;

	@PostConstruct
	private void init() {
		prato = new PratoTO();
		p = new Prato();
	}

	public void buscar() {

		try {
			PratoBOStub stub = new PratoBOStub();
			Buscar buscar = new Buscar();
			buscar.setId(this.codigo);

			BuscarResponse response = stub.buscar(buscar);
			p = response.get_return();
			prato.setId(p.getCodigo());
			prato.setDescricao(p.getDescricao());
			prato.setNome(p.getNome());
			prato.setPreco(p.getPreco());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cadastrar() {
		FacesMessage msg = null;

		try {
			PratoBOStub stub = new PratoBOStub();
			Cadastrar cadastrar = new Cadastrar();

			Prato prato = new Prato();
			prato.setCodigo(0);
			prato.setDescricao(this.prato.getDescricao());
			prato.setNome(this.prato.getNome());
			prato.setPreco(this.prato.getPreco());
			cadastrar.setPrato(prato);
			stub.cadastrar(cadastrar);
			msg = new FacesMessage("Veiculo cadastrado!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (AxisFault e) {
			e.printStackTrace();
			msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			e.printStackTrace();
			msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		} finally {
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public Prato getP() {
		return p;
	}

	public void setP(Prato p) {
		this.p = p;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public PratoTO getPrato() {
		return prato;
	}

	public void setPrato(PratoTO prato) {
		this.prato = prato;
	}

}
