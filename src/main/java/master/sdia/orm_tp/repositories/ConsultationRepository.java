package master.sdia.orm_tp.repositories;

import master.sdia.orm_tp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
