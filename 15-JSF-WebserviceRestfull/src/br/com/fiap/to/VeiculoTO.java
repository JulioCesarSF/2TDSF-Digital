package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

//Para transformar o objeto em json automáticamente
@XmlRootElement
public class VeiculoTO {

	private int codigo;
	
	private String modelo;
	
	private String marca;
	
	private double preco;
	
	public VeiculoTO() {
		super();
	}

	public VeiculoTO(int codigo, String modelo, String marca, double preco) {
		super();
		this.codigo = codigo;
		this.modelo = modelo;
		this.marca = marca;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
