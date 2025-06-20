package virtualPowerPlant.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BatteryDTO {

    @NotBlank
    private String name;

    @Min(1000)
    private int postcode;

    @Positive
    private double wattCapacity;

}
