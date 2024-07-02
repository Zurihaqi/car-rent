package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.utils.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Car create(CarDTO request);
    Page<Car> getAll(Pageable pageable);
    Car getOne(Integer id);
    Car update(Integer id, CarDTO request);
    void delete(Integer id);
}
