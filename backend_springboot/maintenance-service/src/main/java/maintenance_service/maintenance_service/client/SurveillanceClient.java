package maintenance_service.maintenance_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "surveillance-service")
public interface SurveillanceClient {

    @GetMapping("/api/surveillance/alertes")
    Object getAlertes();
}
