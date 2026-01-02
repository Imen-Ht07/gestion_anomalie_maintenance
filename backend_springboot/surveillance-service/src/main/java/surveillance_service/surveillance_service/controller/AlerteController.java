package surveillance_service.surveillance_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import surveillance_service.surveillance_service.entity.Alerte;
import surveillance_service.surveillance_service.service.SurveillanceService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/surveillance/alertes")
public class AlerteController {

    private final SurveillanceService service;

    public AlerteController(SurveillanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alerte> getAlertes() {
        log.info("📡 Récupération des alertes");
        return service.getAlertes();
    }
}