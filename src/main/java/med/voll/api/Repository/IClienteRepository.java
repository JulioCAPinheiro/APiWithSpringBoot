package med.voll.api.Repository;

import med.voll.api.cliente.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<cliente, Long> {
}
