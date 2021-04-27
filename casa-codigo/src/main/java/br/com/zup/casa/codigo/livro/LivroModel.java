package br.com.zup.casa.codigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casa.codigo.autor.AutorModel;
import br.com.zup.casa.codigo.categoria.CategoriaModel;

@Entity
public class LivroModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
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
	private int isbn; //identificador do livro -- tem que ser UniqueValue também 
	
	@NotNull
	@Future
	@JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao; 
	

	@ManyToOne 
	private AutorModel autor;
	@ManyToOne 
	private CategoriaModel categoria; 
		

	@Deprecated
	public LivroModel() {
		
	} 
	
	public LivroModel(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotBlank @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank int isbn,
			@NotNull @Future LocalDate dataPublicacao, AutorModel autor, CategoriaModel categoria) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
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

	public AutorModel getAutor() {
		return autor;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}


}
