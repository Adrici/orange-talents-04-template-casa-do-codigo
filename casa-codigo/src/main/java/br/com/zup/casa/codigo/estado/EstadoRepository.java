package br.com.zup.casa.codigo.estado;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
	Optional<EstadoModel> findById(Long id);
}
