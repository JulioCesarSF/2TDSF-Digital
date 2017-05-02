package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.CongressoBO;
import br.com.fiap.entity.Congresso;

@ManagedBean
public class CongressoBean {

	private Congresso congresso;
	private CongressoBO bo;

	@PostConstruct
	private void init() {
		congresso = new Congresso();
		congresso.setData(Calendar.getInstance()); // inicializa a data
		bo = new CongressoBO();
	}

	public void cadastrar() {
		FacesMessage msg;
		try {
			bo.cadastrar(congresso);
			msg = new FacesMessage("Cadastrado com sucesso!");			
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro! ".concat(e.getMessage()));			
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}

	public CongressoBO getBo() {
		return bo;
	}

	public void setBo(CongressoBO bo) {
		this.bo = bo;
	}

}
