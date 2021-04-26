package br.com.zup.casa.codigo.categoria;

public class CategoriaDtoResponse {
	
	private Long id;
	private String nome;
	
	
	
	//getters
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	 
	// Criar construtores para receber os atributos da classe AutorModel 
	public CategoriaDtoResponse(CategoriaModel categoriaModel) {
		this.id = categoriaModel.getId(); 
		this.nome = categoriaModel.getNome(); 
		}


}
