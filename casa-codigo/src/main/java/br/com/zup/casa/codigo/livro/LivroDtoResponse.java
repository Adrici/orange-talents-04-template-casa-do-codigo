package br.com.zup.casa.codigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casa.codigo.autor.AutorModel;

public class LivroDtoResponse {
	
	private String titulo; 
	private String resumo;
	private String sumario; 
	private BigDecimal preco; 
	private int numeroPaginas;
	private int isbn; 
	private LocalDate dataPublicacao;  
	private Long idCategoria;
	private Long idAutor;
	
	//getters
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
	 
	//contrutores
	public LivroDtoResponse(LivroModel livroModel) {		
		this.titulo = livroModel.getTitulo(); 
		this.resumo = livroModel.getResumo(); 
		this.sumario = livroModel.getSumario(); 
		this.preco = livroModel.getPreco(); 
		this.numeroPaginas= livroModel.getNumeroPaginas(); 
		this.dataPublicacao = livroModel.getDataPublicacao(); 
		this.idCategoria = livroModel.getIdCategoria();
		this.idAutor = livroModel.getIdAutor();
	} 
	
}


