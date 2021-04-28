package br.com.zup.casa.codigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import br.com.zup.casa.codigo.pais.PaisModel;

@Entity
public class EstadoModel {
	
//atributos
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@NotBlank
	private String nomeEstado;
	
	@ManyToOne
	private PaisModel pais;
	
//construtores
	public EstadoModel(@NotBlank String nomeEstado, PaisModel pais) {

	this.nomeEstado = nomeEstado;
	this.pais = pais;
}

	
//getters 
	public Long getId() {
		return id;
	}


	public String getNomeEstado() {
		return nomeEstado;
	}

	public PaisModel getPais() {
		return pais;
	}

}
