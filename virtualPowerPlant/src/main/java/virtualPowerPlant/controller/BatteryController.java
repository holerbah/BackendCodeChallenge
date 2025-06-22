package virtualPowerPlant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualPowerPlant.model.dto.BatteryDTO;
import virtualPowerPlant.model.entity.Battery;
import virtualPowerPlant.service.BatteryService;

import java.util.List;

@RestController
@RequestMapping("api/batteries")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;

    @PostMapping
    public ResponseEntity<List<Battery>> addBatterries(@RequestBody @Valid List<BatteryDTO> batteryDTOs)
    {
        List<Battery> batteries = batteryService.saveAll(batteryDTOs);
        return ResponseEntity.ok(batteries);
    }

}
