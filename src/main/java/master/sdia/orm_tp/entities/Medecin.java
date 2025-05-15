package master.sdia.orm_tp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String specialite;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
}
