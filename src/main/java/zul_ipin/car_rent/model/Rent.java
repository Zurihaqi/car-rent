package zul_ipin.car_rent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean completed;

    @NotNull
    @Column(name = "started_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startedAt;

    @NotNull
    @Column(name = "ends_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endsAt;

    @NotNull
    @Column(name = "rent_price")
    private Integer rentPrice;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
