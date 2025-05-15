package master.sdia.orm_tp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    private String rapport;

    @OneToOne
    private RendezVous rendezVous;
}
