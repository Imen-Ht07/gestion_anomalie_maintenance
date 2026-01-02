package surveillance_service.surveillance_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surveillance_service.surveillance_service.entity.Alerte;

@Repository
public interface AlerteRepository extends JpaRepository<Alerte, Long> {
}