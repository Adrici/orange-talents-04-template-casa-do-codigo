package br.com.zup.casa.codigo.autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PoribeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		 
		return AutorDtoRequest.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) { 
		if(errors.hasErrors()) {
			return;
		}
		
		AutorDtoRequest request = (AutorDtoRequest) target; 
		Optional<AutorModel> possivelAutor = autorRepository.findByEmail(request.getEmail());
		
		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) autor(a) com o mesmo email" +""+ request.getEmail());
		}
	}
	 
}
