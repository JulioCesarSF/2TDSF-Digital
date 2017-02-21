package br.com.fiap.teste;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularPSAnual;
import br.com.fiap.bo.CursoBOStub.CalcularPSAnualResponse;

public class TestePS {

	public static void main(String[] args) {
		//Quanto vc precisa tirar na PS?
		try {
			CursoBOStub bo = new CursoBOStub();
			
			CalcularPSAnual valores = new CalcularPSAnual();
			valores.setAm(10);
			valores.setMedia(4);
			valores.setNac(8);
			
			CalcularPSAnualResponse  response =
								bo.calcularPSAnual(valores);
			
			float ps = response.get_return();
			System.out.println("PS: " + ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
