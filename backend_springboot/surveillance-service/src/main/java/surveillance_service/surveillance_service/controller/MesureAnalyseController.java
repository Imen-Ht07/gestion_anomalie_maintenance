package surveillance_service.surveillance_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import surveillance_service.surveillance_service.entity.MesureAnalyse;
import surveillance_service.surveillance_service.service.SurveillanceService;

@Slf4j
@RestController
@RequestMapping("/api/surveillance/mesures")
public class MesureAnalyseController {

    private final SurveillanceService service;

    public MesureAnalyseController(SurveillanceService service) {
        this.service = service;
    }

    @PostMapping
    public MesureAnalyse analyser(@RequestBody MesureAnalyse mesure) {
        log.info(" Analyse d'une nouvelle mesure");
        return service.analyserMesure(mesure);
    }
}