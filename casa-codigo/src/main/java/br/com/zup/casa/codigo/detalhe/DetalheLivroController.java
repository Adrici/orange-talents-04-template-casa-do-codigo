package br.com.zup.casa.codigo.detalhe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casa.codigo.livro.LivroModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*Criei este package de detalhes, para seguir a didática da vídeo aula proposta. No entanto, 
Usarei a lógica de inserir todo o modelo do crud no controller de Livros, porque faz mais sentido 
para o meu entendimento pessoal. 
*/

	@RestController
	@RequestMapping("/produtos")
	public class DetalheLivroController {
		
		@PersistenceContext
		private EntityManager entityManager;
		
		@GetMapping("/{id}")
		public ResponseEntity<?>buscarPorId(@PathVariable long id){
			LivroModel detalhe = entityManager.find(LivroModel.class, id);
			if(detalhe == null) {
				return ResponseEntity.notFound().build();
			}
			DetalheLivroDtoResponse detalheLivroResponse = new DetalheLivroDtoResponse (detalhe);
			
			return ResponseEntity.ok(detalheLivroResponse);
		}

} 
	

