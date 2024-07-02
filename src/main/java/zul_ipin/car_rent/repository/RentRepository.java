package zul_ipin.car_rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zul_ipin.car_rent.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

}
