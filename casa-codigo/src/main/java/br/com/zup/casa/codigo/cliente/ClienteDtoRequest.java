package br.com.zup.casa.codigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;

import br.com.zup.casa.codigo.compartilhado.CpfOrCnpj;
import br.com.zup.casa.codigo.compartilhado.ExistsId;
import br.com.zup.casa.codigo.estado.EstadoModel;
import br.com.zup.casa.codigo.pais.PaisModel;

public class ClienteDtoRequest {
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@CpfOrCnpj
	private String documento;
	
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	@ExistsId(domainClass= PaisModel.class,fieldName="id", message="Id Inexistente!")
	private Long idPais;
	private Long idEstado;
	
	public ClienteDtoRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, Long idPais, Long idEstado) {
	
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}
	
	
public ClienteModel toModel(EntityManager emt) {
		PaisModel pais = emt.find(PaisModel.class, idPais);
        EstadoModel estado = emt.find(EstadoModel.class, this.idEstado);

        Assert.state(pais != null, "País é um campo obrigatório!");
       
        ClienteModel cliente = new  ClienteModel(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        if(estado != null ) cliente.setEstado(estado);
        	
        return new ClienteModel(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
	}

}
