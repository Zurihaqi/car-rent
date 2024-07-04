package zul_ipin.car_rent.utils.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import zul_ipin.car_rent.model.Rent;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarDTO {
    @NotNull
    private Integer brand_id;
    private String name;
    private Boolean available;
    private Integer price;
    private Rent rent;
}
