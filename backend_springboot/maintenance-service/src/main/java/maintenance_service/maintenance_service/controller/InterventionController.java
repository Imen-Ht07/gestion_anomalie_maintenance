package maintenance_service.maintenance_service.controller;

import lombok.extern.slf4j.Slf4j;
import maintenance_service.maintenance_service.entity.Intervention;
import maintenance_service.maintenance_service.repository.InterventionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/maintenance/interventions")
public class InterventionController {

    private final InterventionRepository repository;

    public InterventionController(InterventionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Intervention> getAll() {
        log.info("Liste des interventions");
        return repository.findAll();
    }
}