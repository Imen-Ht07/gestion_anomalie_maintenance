package maintenance_service.maintenance_service.repository;

import maintenance_service.maintenance_service.entity.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    Optional<Technicien> findFirstByDisponibiliteTrue();
}