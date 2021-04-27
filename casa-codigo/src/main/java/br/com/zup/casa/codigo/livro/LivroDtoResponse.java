package br.com.zup.casa.codigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroDtoResponse {
	
	private Long id;
	private String titulo; 
	private String resumo;
	private String sumario; 
	private BigDecimal preco; 
	private int numeroPaginas;
	private int isbn; 
	@JsonFormat
	private LocalDate dataPublicacao;  
	private Long idCategoria;
	private Long idAutor;
		
	
	public LivroDtoResponse(LivroModel livro) {
		
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo =livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
	
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

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	
}
