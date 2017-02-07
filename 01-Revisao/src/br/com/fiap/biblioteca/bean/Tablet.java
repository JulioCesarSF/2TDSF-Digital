package br.com.fiap.biblioteca.bean;

import br.com.fiap.biblioteca.bean.intefaces.Eletronico;

public class Tablet extends Produto implements Eletronico{
	
	public Tablet() {
		super();
	}

	public Tablet(long codigo, String titulo, double preco, String modelo, String marca, String sistemaOperacional,
			boolean rede3g) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.sistemaOperacional = sistemaOperacional;
		this.rede3g = rede3g;
	}

	private String modelo;
	private String marca;
	private String sistemaOperacional;
	private boolean rede3g;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public boolean isRede3g() {
		return rede3g;
	}

	public void setRede3g(boolean rede3g) {
		this.rede3g = rede3g;
	}

	@Override
	public double calcularGarantia() {		
		return getPreco()*0.05;
	}
	
	@Override
	public String toString() {
		return getTitulo() + "\nModelo: " + modelo + "\nMarca: " + marca + "\n" + sistemaOperacional + "\n" + getPreco() + "\n" + rede3g;
	}

}
