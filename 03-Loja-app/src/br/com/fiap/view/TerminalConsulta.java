package br.com.fiap.view;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import br.com.fiap.bo.EstoqueBO;
import br.com.fiap.config.PropertySingleton;
import br.com.fiap.to.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EstoqueBO bo = new EstoqueBO();
		
		Calendar hoje = Calendar.getInstance();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		String nomeLoja = PropertySingleton.getInstance().getProperty("loja");
		
		System.out.println(nomeLoja + "             " + formatador.format(hoje.getTime()));
		System.out.println("*********************************");
		System.out.print("Código do produto: " );
		int codigo = sc.nextInt();
		ProdutoTO produto = bo.consultarProduto(codigo);
		
		if (produto != null){
			DecimalFormat format = new DecimalFormat("R$ ##,###.00");
			System.out.println(produto.getDescricao());
			System.out.println(format.format(produto.getPreco()));
		}else{
			System.out.println("Produto não cadastrado");
		}
		sc.close();
	}
	
}
