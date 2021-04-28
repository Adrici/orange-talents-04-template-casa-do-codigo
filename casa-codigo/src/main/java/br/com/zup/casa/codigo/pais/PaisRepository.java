package br.com.zup.casa.codigo.pais;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<PaisModel, Long>  {

	Optional<PaisModel> findById(Long id);

	
}
