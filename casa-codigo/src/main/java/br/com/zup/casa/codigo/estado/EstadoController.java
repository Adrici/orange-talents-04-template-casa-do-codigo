package br.com.zup.casa.codigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/estado")
public class EstadoController {

	@Autowired
	private  EstadoRepository estadoRepository; 
	
	@PersistenceContext
	private EntityManager emt;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDtoResponse> cadastrar(@RequestBody @Valid EstadoDtoRequest request) {
	
		EstadoModel estado = request.toModel(emt); 
		estadoRepository.save(estado); 
		
		return ResponseEntity.ok(new EstadoDtoResponse(estado)); 		
	}
	
}
