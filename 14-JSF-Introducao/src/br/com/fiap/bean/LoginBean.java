package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String usuario;
	private String senha;
	
	public void logar(){
		System.out.println(usuario + " " + senha);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
