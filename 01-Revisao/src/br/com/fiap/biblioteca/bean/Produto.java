package br.com.fiap.biblioteca.bean;

public class Produto {
	
	public Produto(long codigo, String titulo, double preco) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
	}
	
	public Produto() {
		super();
	}

	private long codigo;
	
	private String titulo;
	
	private double preco;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
