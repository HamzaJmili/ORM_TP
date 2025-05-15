package master.sdia.orm_tp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class RendezVous {
    @Id
    private String id; // UUID ou string unique
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String status;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
