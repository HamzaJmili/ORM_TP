package master.sdia.orm_tp.repositories;

import master.sdia.orm_tp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
