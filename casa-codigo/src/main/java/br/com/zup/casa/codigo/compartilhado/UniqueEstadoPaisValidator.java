package br.com.zup.casa.codigo.compartilhado;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.casa.codigo.estado.EstadoDtoRequest;

public class UniqueEstadoPaisValidator implements ConstraintValidator<UniqueEstadoPais, EstadoDtoRequest> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void initialize(UniqueEstadoPais uniqueEstadoPais) {
       
    }

    @Override
    public boolean isValid(EstadoDtoRequest value, ConstraintValidatorContext context) {
    	 Query query = em.createQuery(
                 "SELECT 1 FROM EstadoModel c WHERE c.nomeEstado =:nome AND c.pais.id =:idPais");
    	 query.setParameter("nome", value.getNomeEstado());
    	 query.setParameter("idPais", value.getIdPais());
         return query.getResultList().isEmpty();
    }

}