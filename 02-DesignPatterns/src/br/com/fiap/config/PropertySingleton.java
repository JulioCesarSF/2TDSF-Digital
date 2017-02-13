package br.com.fiap.config;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	private static Properties prop;
	
	//Construtor privado, ninguem vai instanciar a classe PropertySingleton
	private PropertySingleton(){}
	
	public static Properties getInstance(){
		if (prop == null){
			//Instanciar o prop
			prop = new Properties();
			//Carregar as informações do arquivo de propriedades
			try{
				prop.load(PropertySingleton
					.class.getResourceAsStream("/config.properties"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return prop;
	}
	
}
