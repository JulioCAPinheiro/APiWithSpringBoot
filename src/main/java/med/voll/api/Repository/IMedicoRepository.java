package med.voll.api.Repository;

import med.voll.api.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository  extends JpaRepository<Medico,Long>{

}
