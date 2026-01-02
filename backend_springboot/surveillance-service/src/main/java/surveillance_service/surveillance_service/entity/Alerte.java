package surveillance_service.surveillance_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data
@Entity
public class Alerte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String message;
    private String niveauGravite;
    private LocalDateTime dateDetection;
}
