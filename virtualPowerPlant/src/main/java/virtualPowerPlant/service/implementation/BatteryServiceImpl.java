package virtualPowerPlant.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import virtualPowerPlant.model.dto.BatteryDTO;
import virtualPowerPlant.model.dto.BatteryStatisticsResponse;
import virtualPowerPlant.model.entity.Battery;
import virtualPowerPlant.repository.BatteryRepository;
import virtualPowerPlant.service.BatteryService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    @Value("${batteries.sort-order:asc}")
    private String sortOrder;

    @Override
    public List<Battery> saveAll(List<BatteryDTO> batteryDTOs) {
        List<Battery> batteries = batteryDTOs.stream()
                .map(dto -> new Battery(0L, dto.getName(), dto.getPostcode(), dto.getWattCapacity()))
                .collect(Collectors.toList());
        return batteryRepository.saveAll(batteries);
    }

    @Override
    public BatteryStatisticsResponse getBatteriesInRange(int from, int to) {

        List<Battery> batteries = batteryRepository.findByPostcodeBetween(from, to);

        Comparator<Battery> batteryComparator = Comparator.comparing(Battery::getName);
        if("desc".equalsIgnoreCase(sortOrder))
        {
            batteryComparator = batteryComparator.reversed();
        }

        List<String> sortedNames = batteries.stream()
                .sorted(batteryComparator)
                .map(Battery::getName)
                .toList();

        double total = batteries.stream()
                .mapToDouble(Battery::getWattCapacity)
                .sum();

        double average = batteries.isEmpty() ? 0 : total / batteries.size();

        return new BatteryStatisticsResponse(sortedNames, total, average);
    }


}
