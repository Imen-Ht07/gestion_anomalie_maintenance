package maintenance_service.maintenance_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Intervention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alerteId;
    private Long technicienId;
    private LocalDateTime datePlanifiee;
    private String statut;
}