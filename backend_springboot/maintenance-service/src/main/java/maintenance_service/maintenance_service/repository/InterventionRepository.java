package maintenance_service.maintenance_service.repository;

import maintenance_service.maintenance_service.entity.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {}