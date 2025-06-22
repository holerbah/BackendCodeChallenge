package virtualPowerPlant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virtualPowerPlant.model.entity.Battery;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
}
