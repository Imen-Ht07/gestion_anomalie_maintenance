package surveillance_service.surveillance_service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import surveillance_service.surveillance_service.config.RabbitMQConfig;
import surveillance_service.surveillance_service.dto.AlerteEventDTO;

@Slf4j
@Service
public class AlerteProducer {

    private final RabbitTemplate rabbitTemplate;

    public AlerteProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendAlerte(AlerteEventDTO event) {
        log.info("Envoi alerte vers RabbitMQ | id={} | gravité={}",
                event.getAlerteId(), event.getNiveauGravite());

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                event
        );
    }
}