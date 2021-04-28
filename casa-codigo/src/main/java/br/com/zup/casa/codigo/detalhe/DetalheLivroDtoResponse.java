package br.com.zup.casa.codigo.detalhe;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casa.codigo.livro.LivroModel;

public class DetalheLivroDtoResponse {
	
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
		

	public DetalheLivroDtoResponse(LivroModel detalhe) {
		
		this.titulo = detalhe.getTitulo();
		this.resumo = detalhe.getResumo();
		this.sumario = detalhe.getSumario();
		this.preco = detalhe.getPreco();
		this.numeroPaginas = detalhe.getNumeroPaginas();
		this.isbn = detalhe.getIsbn();
		this.dataPublicacao = detalhe.getDataPublicacao();
		/*this.idCategoria = detalhe.getIdCategoria();
		this.idAutor = detalhe.getIdAutor();*/ 
		// fiz esses atributos so na livroResponse,usando a logica do repositorio
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
