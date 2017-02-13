package br.com.fiap.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.fiap.config.PropertySingleton;

public class Teste {
	
	private static Logger log = LoggerFactory.getLogger(Teste.class);

	public static void main(String[] args) {
		//Ler as propriedades do sistema
		log.trace("Lendo as informações do sistema");
		
		String nomeAplicacao = PropertySingleton
				.getInstance().getProperty("application_name");
		String versao = PropertySingleton.getInstance().getProperty("versao");
		
		log.debug("Exibindo o nome e versão da aplicação");
		
		System.out.println("Aplicação: " + nomeAplicacao + " " + versao);
		
	}
	
}
