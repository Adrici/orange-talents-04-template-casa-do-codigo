package br.com.zup.casa.codigo.livro;

import java.util.List;
import java.util.Optional;
import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casa.codigo.autor.AutorDtoRequest;
import br.com.zup.casa.codigo.autor.AutorDtoResponse;
import br.com.zup.casa.codigo.autor.AutorModel;
import br.com.zup.casa.codigo.autor.AutorRepository;

@RestController
@RequestMapping ("/livros")
public class LivroController  {
	
	@Autowired
	private  LivroRepository livroRepository; 
	
	@PersistenceContext
	private EntityManager em; 
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDtoResponse> cadastrar(@RequestBody @Valid LivroDtoRequest request) {
	
		LivroModel livro = request.toModel(em); 
		livroRepository.save(livro); 
		
		return ResponseEntity.ok(new LivroDtoResponse(livro));  
		
	}
	
	
	//get geral findAll
	@GetMapping
	public ResponseEntity<List<LivroModel>> GetAll(){ 
		return ResponseEntity.ok(livroRepository.findAll());
	}

	 
	/*//para listar por id a lista de livros --antes de ver a vídeo aula
		@GetMapping("/{id}")
		public ResponseEntity<LivroDtoResponse> listar(@PathVariable Long id) {
		Optional<LivroModel> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new LivroDtoResponse(livro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}*/
	
	
}