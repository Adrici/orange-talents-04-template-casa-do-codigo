package br.com.zup.casa.codigo.autor;




// DtoResponse é o que retornamos para o usuario 
public class AutorDtoResponse {
	
	
	private Long id;
	private String nome;
	private String email;

	//getters
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}

	 
	// Criar construtores para receber os atributos da classe AutorModel 
	public AutorDtoResponse(AutorModel autorModel) {
		this.id = autorModel.getId(); 
		this.nome = autorModel.getNome(); 
		this.email = autorModel.getEmail();
		
		 
	}
}
