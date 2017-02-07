package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.biblioteca.bean.Livro;

public class Teste2 {

	public static void main(String[] args) {
		Livro livro1 = new Livro(1,"As aventuras de miau", 100, 
				"Gato","Tom",Calendar.getInstance());
		Livro livro2 = new Livro(2,"Java como programar", 500, 
				"Deitel", "Alta Books", new GregorianCalendar(2010,Calendar.APRIL,2));
		Livro livro3 = new Livro(3,"Aprenda C# em 15 dias",250,"Joao",
				"Globo",Calendar.getInstance());
		
		//Coleção
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		
		//Imprimir os livros
		for (Livro livro : livros) {
			System.out.println(livro);
		}
				
	}
	
}
