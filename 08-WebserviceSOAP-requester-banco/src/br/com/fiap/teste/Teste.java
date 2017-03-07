package br.com.fiap.teste;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.PratoBOStub;
import br.com.fiap.bo.PratoBOStub.Cadastrar;
import br.com.fiap.bo.PratoBOStub.Prato;

public class Teste {

	public static void main(String[] args) {
		
		try {
			PratoBOStub stub = new PratoBOStub();
			
			//Valores para o webservice
			Cadastrar params = new Cadastrar();
			Prato prato = new Prato();
			prato.setDescricao("Feijoada completa");
			prato.setNome("Feijoada");
			prato.setPreco(30);
			
			params.setPrato(prato);
			
			stub.cadastrar(params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
