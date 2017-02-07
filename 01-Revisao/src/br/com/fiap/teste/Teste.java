package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import br.com.fiap.biblioteca.bean.Livro;
import br.com.fiap.biblioteca.bean.Tablet;

public class Teste {

	public static void main(String[] args) {
		Livro livro = new Livro(1,
				"Harry Potter",100, "J. K. Holling","Rocco",
									//Ano, Mes, Dia
				new GregorianCalendar(2001,Calendar.JANUARY, 1));
		// Data atual: Calendar.getInstance();
		
		Tablet tablet = new Tablet(1, "Lenovo 830", 500, "830", 
				"Lenovo", "Android", true);
		
		System.out.println("Livro: " + livro);
		System.out.println("Tablet: " + tablet);
		System.out.println("Garantia: " + tablet.calcularGarantia());
		
	}
	
}
