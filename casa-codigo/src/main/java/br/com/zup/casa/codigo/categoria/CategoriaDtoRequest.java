package br.com.zup.casa.codigo.categoria;


import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;

public class CategoriaDtoRequest {
	
	@NotBlank 
	@JoinColumn(unique = true) 
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
