package br.com.zup.casa.codigo.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class PaisModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private Long id;
	 
	@NotBlank
	 private String nomePais;
	 
	 @Deprecated
	 public PaisModel(){
		 
	 }
	 
//fields constructors 
 public PaisModel(@NotBlank String nomePais) {
	 this.nomePais = nomePais;
	 }


//getters
	public Long getId() {
		return id;
	}

	
	public String getNomePais() {
		return nomePais;
	}
	 

}
