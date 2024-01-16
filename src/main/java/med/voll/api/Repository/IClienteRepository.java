package med.voll.api.Repository;

import med.voll.api.cliente.cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<cliente, Long> {
    Page<cliente> findAllAtivoTrue(Pageable paginacao);
}
