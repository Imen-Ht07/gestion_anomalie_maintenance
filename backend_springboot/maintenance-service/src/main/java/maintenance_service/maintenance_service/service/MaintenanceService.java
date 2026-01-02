package maintenance_service.maintenance_service.service;

import lombok.extern.slf4j.Slf4j;
import maintenance_service.maintenance_service.dto.AlerteEventDTO;
import maintenance_service.maintenance_service.entity.Intervention;
import maintenance_service.maintenance_service.entity.Technicien;
import maintenance_service.maintenance_service.repository.InterventionRepository;
import maintenance_service.maintenance_service.repository.TechnicienRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class MaintenanceService {

    private final InterventionRepository interventionRepo;
    private final TechnicienRepository technicienRepo;

    public MaintenanceService(InterventionRepository interventionRepo,
                              TechnicienRepository technicienRepo) {
        this.interventionRepo = interventionRepo;
        this.technicienRepo = technicienRepo;
    }

    public void creerIntervention(AlerteEventDTO alerte) {

        log.info(" Alerte reçue | id={} | gravité={}",
                alerte.getAlerteId(), alerte.getNiveauGravite());

        Technicien tech = technicienRepo.findFirstByDisponibiliteTrue()
                .orElse(null);

        Intervention intervention = new Intervention();
        intervention.setAlerteId(alerte.getAlerteId());
        intervention.setTechnicienId(tech != null ? tech.getId() : null);
        intervention.setDatePlanifiee(LocalDateTime.now().plusDays(1));
        intervention.setStatut("PLANIFIEE");

        interventionRepo.save(intervention);

        log.info("🔧 Intervention créée | id={}", intervention.getId());
    }
}
