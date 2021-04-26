package br.com.zup.casa.codigo.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeCategoriaDuplicadaCategoriaValidator implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		 
		return CategoriaDtoRequest.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) { 
		if(errors.hasErrors()) {
			return; 
		}
		
		CategoriaDtoRequest request = (CategoriaDtoRequest) target; 
		Optional<CategoriaModel> possivelCategoria = categoriaRepository.findByNome(request.getNome());
		
		if (possivelCategoria.isPresent()) {
			errors.rejectValue("Nome", null, "Esta categoria já existe em nosso banco de dados!" +""+ request.getNome());
		}	
	}


}
