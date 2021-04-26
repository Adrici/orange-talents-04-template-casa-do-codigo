package br.com.zup.casa.codigo.categoria;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	Optional<CategoriaModel> findByNome(String nome);

}
