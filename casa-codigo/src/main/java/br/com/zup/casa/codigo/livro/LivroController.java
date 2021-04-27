package br.com.zup.casa.codigo.livro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDtoResponse> cadastrar(@RequestBody @Valid LivroDtoRequest request) {
	
		LivroModel livro = request.toModel(); 
		livroRepository.save(livro); 
		
		return ResponseEntity.ok(new LivroDtoResponse(livro)); 
		
	}
	

}
