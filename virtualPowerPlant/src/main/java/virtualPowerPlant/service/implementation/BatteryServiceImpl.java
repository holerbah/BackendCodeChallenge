package virtualPowerPlant.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualPowerPlant.model.dto.BatteryDTO;
import virtualPowerPlant.model.entity.Battery;
import virtualPowerPlant.repository.BatteryRepository;
import virtualPowerPlant.service.BatteryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    @Override
    public List<Battery> saveAll(List<BatteryDTO> batteryDTOs) {
        List<Battery> batteries = batteryDTOs.stream()
                .map(dto -> new Battery(0L, dto.getName(), dto.getPostcode(), dto.getWattCapacity()))
                .collect(Collectors.toList());
        return batteryRepository.saveAll(batteries);
    }

}
