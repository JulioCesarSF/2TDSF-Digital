package br.com.fiap.teste;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularMedia;
import br.com.fiap.bo.CursoBOStub.CalcularMediaResponse;

public class CursoTeste {

	public static void main(String[] args) {
		
		try {
			CursoBOStub bo = new CursoBOStub();
			
			//Valores para o webservice
			CalcularMedia valores = new CalcularMedia();
			valores.setAm(10);
			valores.setNac(10);
			valores.setPs(2);
			
			//Chama o webservice
			CalcularMediaResponse response = 
								bo.calcularMedia(valores);
			
			//Recupera o valor da resposta do websevice
			float media = response.get_return();
			System.out.println("Média: " + media);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
