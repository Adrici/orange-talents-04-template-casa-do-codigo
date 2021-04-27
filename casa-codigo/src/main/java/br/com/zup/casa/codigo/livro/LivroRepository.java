package br.com.zup.casa.codigo.livro;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {
	Optional<LivroModel> findByTitulo(String titulo);
}

