package zul_ipin.car_rent.utils.DTO;

import lombok.*;

import java.util.Date;

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
