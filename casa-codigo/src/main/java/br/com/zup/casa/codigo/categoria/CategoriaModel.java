package br.com.zup.casa.codigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class CategoriaModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank 
	@JoinColumn(unique = true) 
	private String nome;
	
	@Deprecated
	public CategoriaModel(){
		
	}

	public CategoriaModel(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	//getters

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
