package virtualPowerPlant.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Schema(description = "Response DTO containing battery names and watt capacity statistics")
public class BatteryStatisticsResponse {

    @Schema(description = "List of battery names within the postcode range")
    private List<String> batteryName;

    @Schema(description = "Total watt capacity of the batteries in the range", example = "4500.0")
    private double totalWattCapacity;

    @Schema(description = "Average watt capacity of the batteries in the range", example = "1500.0")
    private double averageWattCapacity;

}
