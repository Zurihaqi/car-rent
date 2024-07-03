package zul_ipin.car_rent.utils.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    @NotNull
    private Integer user_id;
    @NotNull
    private Integer car_id;
}
