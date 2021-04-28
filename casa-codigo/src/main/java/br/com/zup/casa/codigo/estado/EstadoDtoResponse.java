package br.com.zup.casa.codigo.estado;



public class EstadoDtoResponse {

	private Long id;
	private String nomeEstado;
	
	public EstadoDtoResponse(EstadoModel estado) {
	
		this.id = estado.getId();
		this.nomeEstado = estado.getNomeEstado();
	}
	public Long getId() {
		return id;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}

	
}
