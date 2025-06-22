package virtualPowerPlant.service;

import virtualPowerPlant.model.dto.BatteryDTO;
import virtualPowerPlant.model.entity.Battery;

import java.util.List;

public interface BatteryService {

    List<Battery> saveAll(List<BatteryDTO> batteryDTOs);

}
