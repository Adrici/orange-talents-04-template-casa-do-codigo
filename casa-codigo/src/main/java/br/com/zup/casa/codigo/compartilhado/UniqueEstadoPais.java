package br.com.zup.casa.codigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {UniqueEstadoPaisValidator.class})
public @interface UniqueEstadoPais {
    String message() default "Error: Somente valores únicos são aceitos!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 
}