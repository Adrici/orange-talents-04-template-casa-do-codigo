package br.com.zup.casa.codigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casa.codigo.autor.AutorModel;
import br.com.zup.casa.codigo.categoria.CategoriaModel;
import br.com.zup.casa.codigo.compartilhado.UniqueValue;

public class LivroDtoRequest {
	@NotBlank
	@UniqueValue(domainClass =LivroModel.class, fieldName = "titulo")
	private String titulo; // deve ser unico - @UniqueValue na LivroDtoRequest 
	
	@NotBlank
	@Size (max=500)
	private String resumo;
	
	@NotBlank
	private String sumario; //deve ser formato markdown 
	
	@NotBlank
	@Min (value=20)
	private BigDecimal preco; 
	
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	@UniqueValue(domainClass =LivroModel.class, fieldName = "isbn")
	private int isbn; //identificador do livro -- tem que ser UniqueValue também 
	
	@NotNull
	@Future
	@JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao; 
	
	@NotNull
	private Long idCategoria;
	
	@NotNull
	private Long idAutor;

	public LivroDtoRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotBlank @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank int isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
	
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public int getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	
	
	
	public LivroModel toModel(EntityManager em) {
	
		AutorModel autor = em.find(AutorModel.class, this.idAutor);
		CategoriaModel categoria = em.find(CategoriaModel.class, this.idCategoria);
		
		return new LivroModel(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
	} 
	
}
