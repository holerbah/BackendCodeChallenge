package virtualPowerPlant.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BatteryDTO {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Positive(message = "Postcode value must be a positive value")
    private int postcode;

    @Positive(message = "Watt capacity value must be a positive value")
    private double wattCapacity;

}
