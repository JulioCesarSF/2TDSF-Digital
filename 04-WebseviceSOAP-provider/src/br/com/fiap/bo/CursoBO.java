package br.com.fiap.bo;

public class CursoBO {

	public float calcularMedia(float nac, float am, float ps){
		return nac*0.2f + am*0.3f + ps*0.5f;
	}
	
	public float calcularPS(float nac, float am){
		//Retorna a nota da PS para passar
		return (6 - (nac*0.2f + am *0.3f))*2;
	}
	
	public float calcularPSAnual(float nac,
								float am, float media){
		return (12 - (media + nac*0.2f + am*0.3f))*2;
	}
	
}
