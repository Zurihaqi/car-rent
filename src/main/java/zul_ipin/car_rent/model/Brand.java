package zul_ipin.car_rent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank
    String name;
}
