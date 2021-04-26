package br.com.zup.casa.codigo.categoria;


import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaNovaController {

	@Autowired
	private  CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProibeCategoriaDuplicadaCategoriaValidator proibeCategoriaDuplicadaCategoriaValidator; 
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDtoResponse> cadastrar(@RequestBody @Valid CategoriaDtoRequest request) {
	
		CategoriaModel categoria = request.toModel(); 
		categoriaRepository.save(categoria); 
		
		return ResponseEntity.ok(new CategoriaDtoResponse(categoria)); 
		
	}
	

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeCategoriaDuplicadaCategoriaValidator);
		
	}
}
