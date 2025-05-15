package master.sdia.orm_tp.repositories;

import master.sdia.orm_tp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean malade);
    List<Patient> findByNomContains(String keyword);
}
