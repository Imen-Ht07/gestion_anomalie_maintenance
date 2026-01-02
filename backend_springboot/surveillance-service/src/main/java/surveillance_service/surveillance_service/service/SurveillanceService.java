package surveillance_service.surveillance_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import surveillance_service.surveillance_service.dto.AlerteEventDTO;
import surveillance_service.surveillance_service.entity.Alerte;
import surveillance_service.surveillance_service.entity.MesureAnalyse;
import surveillance_service.surveillance_service.producer.AlerteProducer;
import surveillance_service.surveillance_service.repository.AlerteRepository;
import surveillance_service.surveillance_service.repository.MesureAnalyseRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class SurveillanceService {

    private final AlerteRepository alerteRepo;
    private final MesureAnalyseRepository mesureRepo;
    private final AlerteProducer producer;

    public SurveillanceService(AlerteRepository alerteRepo,
                               MesureAnalyseRepository mesureRepo,
                               AlerteProducer producer) {
        this.alerteRepo = alerteRepo;
        this.mesureRepo = mesureRepo;
        this.producer = producer;
    }

    public MesureAnalyse analyserMesure(MesureAnalyse mesure) {

        log.debug(" Nouvelle mesure reçue : {}", mesure);
        mesureRepo.save(mesure);

        if (mesure.getValeur() > 100) {
            log.warn("Anomalie détectée | source={} | valeur={}",
                    mesure.getSourceId(), mesure.getValeur());

            Alerte alerte = new Alerte();
            alerte.setType("SEUIL_DEPASSE");
            alerte.setMessage("Valeur critique détectée");
            alerte.setNiveauGravite("CRITIQUE");
            alerte.setDateDetection(LocalDateTime.now());

            alerteRepo.save(alerte);

            AlerteEventDTO event = new AlerteEventDTO();
            event.setAlerteId(alerte.getId());
            event.setType(alerte.getType());
            event.setNiveauGravite(alerte.getNiveauGravite());
            event.setDateDetection(alerte.getDateDetection());

            producer.sendAlerte(event);
        }

        return mesure;
    }

    public List<Alerte> getAlertes() {
        return alerteRepo.findAll();
    }
}