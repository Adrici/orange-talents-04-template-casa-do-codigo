package br.com.zup.casa.codigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.zup.casa.codigo.compartilhado.ExistsId;
import br.com.zup.casa.codigo.compartilhado.UniqueEstadoPais;
import br.com.zup.casa.codigo.pais.PaisModel;

@UniqueEstadoPais
public class EstadoDtoRequest {  
	
	@NotBlank
/*@UniqueValue(domainClass = PaisModel.class, fieldName = "nomeEstado")*/ //essa anotação caiu pq usamos uma personalizada para a classe toda - @UniqueEstadoPais
	private String nomeEstado;	
	
	
@ExistsId(domainClass= PaisModel.class,fieldName="id")
private Long idPais;

	public EstadoDtoRequest(@NotBlank @JsonProperty("nomeEstado") String nomeEstado) {
		
		this.nomeEstado = nomeEstado;
	}
	
//getters
	public String getNomeEstado() {
		return nomeEstado;
	}
			
public Long getIdPais() {
		return idPais;
	}

//construtor2 
public EstadoModel toModel(EntityManager emt) {
		
		PaisModel pais = emt.find(PaisModel.class, this.idPais);
		return new EstadoModel(nomeEstado, pais);
	}
	
}
