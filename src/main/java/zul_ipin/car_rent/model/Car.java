package zul_ipin.car_rent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    private Boolean available;
    @NotNull
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
