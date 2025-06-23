package virtualPowerPlant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import virtualPowerPlant.model.dto.BatteryDTO;
import virtualPowerPlant.model.dto.BatteryStatisticsResponse;
import virtualPowerPlant.service.BatteryService;

import java.util.List;

@RestController
@RequestMapping("api/batteries")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;

    @Operation(summary = "Add a list of batteries")
    @ApiResponse(responseCode = "201", description = "Batteries created successfully")
    @ApiResponse(responseCode = "400", description = "Battery list is empty or invalid", content = @Content)
    @PostMapping
    public ResponseEntity<?> addBatterries(@RequestBody @Valid List<@Valid BatteryDTO> batteryDTOs)
    {
        if(batteryDTOs.isEmpty())
        {
            return ResponseEntity.badRequest().body("Battery list must not be empty");
        }

        batteryService.saveAll(batteryDTOs);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get batteries in postcode range")
    @ApiResponse(responseCode = "200", description = "Returns batteries with statistics")
    @GetMapping
    public ResponseEntity<?> getBatteriesInRange(
            @Parameter(description = "From postcode") @RequestParam int fromPostcode,
            @Parameter(description = "To postcode") @RequestParam int toPostcode)
    {

        if (fromPostcode < 0 || toPostcode < 0 || fromPostcode > toPostcode) {
            return ResponseEntity.badRequest().body("Invalid postcode range: from=" + fromPostcode + ", to=" + toPostcode);
        }

        return ResponseEntity.ok(batteryService.getBatteriesInRange(fromPostcode, toPostcode));
    }

}
