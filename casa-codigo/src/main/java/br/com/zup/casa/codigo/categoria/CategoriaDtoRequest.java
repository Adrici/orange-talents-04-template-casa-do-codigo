package br.com.zup.casa.codigo.categoria;

import javax.validation.constraints.NotBlank;
import br.com.zup.casa.codigo.compartilhado.UniqueValue;

public class CategoriaDtoRequest {
	
	@NotBlank 
	@UniqueValue(domainClass= CategoriaModel.class, fieldName ="nome")
	private String nome;
	
	
	public CategoriaDtoRequest( @NotBlank String nome) {
		
		this.nome = nome;
	}

	@Deprecated
	public CategoriaDtoRequest() {
		
	}

	
	public String getNome() {
		return nome;
	}
	
	public CategoriaModel toModel() {
		return new CategoriaModel(this.nome); 
	}
	

}
