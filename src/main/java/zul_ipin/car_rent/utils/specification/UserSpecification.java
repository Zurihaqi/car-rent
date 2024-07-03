package zul_ipin.car_rent.utils.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import zul_ipin.car_rent.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    public static Specification<User> getSpecification(String name){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(name != null && !name.isBlank()){
                predicates.add(criteriaBuilder.like(root.get("name"), "%"+name+"%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
