package br.com.zup.casa.codigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casa.codigo.autor.AutorModel;
import br.com.zup.casa.codigo.categoria.CategoriaModel;
import br.com.zup.casa.codigo.compartilhado.ExistsId;
import br.com.zup.casa.codigo.compartilhado.UniqueValue;
import br.com.zup.casa.codigo.livro.LivroModel;
import br.com.zup.casa.codigo.pais.PaisModel;

public class EstadoDtoRequest {  
	@NotBlank
	@UniqueValue(domainClass = PaisModel.class, fieldName = "nome")
	private String nomeEstado;	
	
	@NotNull

@ExistsId(domainClass= PaisModel.class,fieldName="id")
private Long idPais;
	
	public EstadoDtoRequest(@NotBlank String nomeEstado) {
		
		this.nomeEstado = nomeEstado;
	}

//getters
	public String getNomeEstado() {
		return nomeEstado;
	}
		
//construtor2 
	public EstadoModel toModel(EntityManager emt) {
		
		PaisModel pais = emt.find(PaisModel.class, this.idPais);
		return new EstadoModel(nomeEstado, pais);
	}
	
}
