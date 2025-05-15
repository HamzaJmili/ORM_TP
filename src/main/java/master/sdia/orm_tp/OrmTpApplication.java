package master.sdia.orm_tp;

import master.sdia.orm_tp.entities.Consultation;
import master.sdia.orm_tp.entities.Medecin;
import master.sdia.orm_tp.entities.Patient;
import master.sdia.orm_tp.entities.RendezVous;
import master.sdia.orm_tp.repositories.ConsultationRepository;
import master.sdia.orm_tp.repositories.MedecinRepository;
import master.sdia.orm_tp.repositories.PatientRepository;
import master.sdia.orm_tp.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class OrmTpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmTpApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository
    ) {
        return args -> {

            // Ajout de patients
            if (patientRepository.count() == 0) {
                patientRepository.save(Patient.builder().nom("Hassan").dateNaissance(new Date()).malade(false).score(120).build());
                patientRepository.save(Patient.builder().nom("Imane").dateNaissance(new Date()).malade(true).score(180).build());
                patientRepository.save(Patient.builder().nom("Yassine").dateNaissance(new Date()).malade(false).score(90).build());
            }

            Patient p1 = patientRepository.findAll().get(0); // premier patient

            // Ajout de médecin
            Medecin m1 = medecinRepository.save(Medecin.builder()
                    .nom("Dr. Hamza")
                    .email("Hamza@gmail.com")
                    .specialite("Cardiologie")
                    .build());

            // Ajout de rendez-vous
            RendezVous rdv = rendezVousRepository.save(RendezVous.builder()
                    .id(UUID.randomUUID().toString())
                    .date(new Date())
                    .status("PENDING")
                    .patient(p1)
                    .medecin(m1)
                    .build());

            // Ajout de consultation
            consultationRepository.save(Consultation.builder()
                    .dateConsultation(new Date())
                    .rapport("RAS, bon état général.")
                    .rendezVous(rdv)
                    .build());

            // Affichage des données
            System.out.println("\n--- Liste des patients ---");
            patientRepository.findAll().forEach(p -> {
                System.out.println("[" + p.getId() + "] " + p.getNom() + " | Score: " + p.getScore() + " | Malade: " + p.isMalade());
            });

            System.out.println("\n--- Liste des médecins ---");
            medecinRepository.findAll().forEach(m -> {
                System.out.println("[" + m.getId() + "] " + m.getNom() + " | Spécialité: " + m.getSpecialite());
            });

            System.out.println("\n--- Liste des rendez-vous ---");
            rendezVousRepository.findAll().forEach(r -> {
                System.out.println("[" + r.getId() + "] " + r.getDate() + " | Patient: " + r.getPatient().getNom() + " | Médecin: " + r.getMedecin().getNom());
            });

            System.out.println("\n--- Liste des consultations ---");
            consultationRepository.findAll().forEach(c -> {
                System.out.println("Consultation le " + c.getDateConsultation()
                        + " | Rapport: " + c.getRapport()
                        + " | Patient: " + c.getRendezVous().getPatient().getNom());
            });
        };
    }
}
