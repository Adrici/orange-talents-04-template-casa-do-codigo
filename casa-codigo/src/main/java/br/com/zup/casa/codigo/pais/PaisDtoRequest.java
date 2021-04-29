package br.com.zup.casa.codigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;


import br.com.zup.casa.codigo.compartilhado.UniqueValue;

public class PaisDtoRequest {
	
	 @NotBlank
	 @UniqueValue(domainClass = PaisModel.class, fieldName = "nomePais")
	 private String nomePais;


	public PaisDtoRequest(@NotBlank @JsonProperty("nomePais") String nomePais) {
		
		this.nomePais = nomePais;
	}
	

//getters 
	public String getNomePais() {
		return nomePais;
	}
	 
	
	public PaisModel toModel() {
		return new PaisModel(this.nomePais); 
	}
	
	
}
