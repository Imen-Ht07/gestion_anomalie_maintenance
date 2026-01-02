package maintenance_service.maintenance_service.consumer;
import lombok.extern.slf4j.Slf4j;
import maintenance_service.maintenance_service.config.RabbitMQConfig;
import maintenance_service.maintenance_service.dto.AlerteEventDTO;
import maintenance_service.maintenance_service.service.MaintenanceService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AlerteConsumer {

    private final MaintenanceService maintenanceService;

    public AlerteConsumer(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeAlerte(AlerteEventDTO event) {
        log.info("Message RabbitMQ reçu");
        maintenanceService.creerIntervention(event);
    }
}