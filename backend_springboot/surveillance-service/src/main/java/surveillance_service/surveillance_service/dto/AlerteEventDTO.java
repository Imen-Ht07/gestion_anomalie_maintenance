package surveillance_service.surveillance_service.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlerteEventDTO {
    private Long alerteId;
    private String type;
    private String niveauGravite;
    private LocalDateTime dateDetection;
}