package br.com.zup.casa.codigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zup.casa.codigo.autor.AutorModel;
import br.com.zup.casa.codigo.compartilhado.UniqueValue;

public class PaisDtoRequest {
	
	 @NotBlank
	 @UniqueValue(domainClass = PaisModel.class, fieldName = "nome")
	 private String nomePais;

	public PaisDtoRequest(String nomePais) {
		
		this.nomePais = nomePais;
	}

	public String getNomePais() {
		return nomePais;
	}
	 
	
	public PaisModel toModel() {
		return new PaisModel(this.nomePais); 
	}
	
	
}
