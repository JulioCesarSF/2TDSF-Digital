package br.com.fiap.teste;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CResultado;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class TesteCorreios {

	public static void main(String[] args) {
		try {
			//Chamar o ws dos correios
			CalcPrecoPrazoWSStub bo = new CalcPrecoPrazoWSStub();
			
			//Valores para o ws
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010"); //SEDEX
			valores.setSCepDestino("17017510");
			valores.setSCepOrigem("05016090");
			
			//Chama o ws
			CalcPrazoResponse response = bo.calcPrazo(valores);
			
			//Recupera a resposta
			CResultado result = response.getCalcPrazoResult();
			String prazo = result.getServicos()
					.getCServico()[0].getPrazoEntrega();
			
			System.out.println("Prazo: " + prazo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
