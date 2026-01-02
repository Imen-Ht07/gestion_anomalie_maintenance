package surveillance_service.surveillance_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@Slf4j

public class SurveillanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveillanceServiceApplication.class, args);
        log.info("Surveillance Service démarré avec succès");
    }
}
