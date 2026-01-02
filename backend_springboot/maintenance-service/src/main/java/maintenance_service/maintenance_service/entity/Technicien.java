package maintenance_service.maintenance_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Technicien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String specialite;
    private Boolean disponibilite;
}