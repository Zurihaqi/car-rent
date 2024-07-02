package zul_ipin.car_rent.utils.DTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarDTO {
    private Integer brand_id;
    private List<CarDTO> rents;
}
