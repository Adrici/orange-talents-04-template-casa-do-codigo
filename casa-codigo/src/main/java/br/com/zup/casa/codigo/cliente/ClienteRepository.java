package br.com.zup.casa.codigo.cliente;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	Optional<ClienteModel> findById(Long id);
}
