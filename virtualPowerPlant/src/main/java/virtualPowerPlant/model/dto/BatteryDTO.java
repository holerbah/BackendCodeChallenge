package virtualPowerPlant.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object representing a Battery")
public class BatteryDTO {

    @NotBlank(message = "Name must not be blank")
    @Schema(description = "Name of the battery", example = "Battery A")
    private String name;

    @Positive(message = "Postcode value must be a positive value")
    @Schema(description = "Postcode of the battery location", example = "2000", minimum = "1")
    private int postcode;

    @Positive(message = "Watt capacity value must be a positive value")
    @Schema(description = "Watt capacity of the battery", example = "1500.5", minimum = "0.1")
    private double wattCapacity;

}
