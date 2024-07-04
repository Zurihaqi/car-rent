package zul_ipin.car_rent.utils.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import zul_ipin.car_rent.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarSpecification {
    public static Specification<Car> getSpecification(String name, Boolean available){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(name != null && !name.isBlank()){
                predicates.add(criteriaBuilder.like(root.get("name"), "%"+name+"%"));
            }

            if(available != null){
                predicates.add(criteriaBuilder.equal(root.get("available"), available));
            }

            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };
    }
}
