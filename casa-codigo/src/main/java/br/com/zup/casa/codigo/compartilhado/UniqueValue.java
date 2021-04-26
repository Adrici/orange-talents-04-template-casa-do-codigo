package br.com.zup.casa.codigo.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {


	//default se falhar 	
	String message() default "{com.adrici.beanvalidation.uniquevalue)";
		
	//validação para grupo especifico ( ex.: adminsitradores , nao admin)
	Class<?>[] groups() default { }; 
		
	//info a mais para a validação
	Class<? extends Payload>[] payload() default { }; 
			
		String fieldName();	
		Class<?> domainClass();
	
	
}
