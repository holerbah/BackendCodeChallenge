package virtualPowerPlant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virtualPowerPlant.model.entity.Battery;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {

    List<Battery> findByPostcodeBetween(int from, int to);

}
