package zul_ipin.car_rent.utils.DTO;

import lombok.*;
import zul_ipin.car_rent.model.Rent;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentDTO{
    private boolean completed;
    private Date started_at;
    private Date ends_at;
    private Integer rent_price;
    private Integer user_id;
    private Integer car_id;
}
