package br.com.zup.casa.codigo.pais;


public class PaisDtoResponse {

	 private String nomePais;
	 
	//construtor
	public PaisDtoResponse(PaisModel pais) {
	
		this.nomePais = pais.getNomePais();
	}
	
	//getters 
	public String getNomePais() {
		return nomePais;
	}
	 
		
}
