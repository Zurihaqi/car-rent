package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.model.User;
import zul_ipin.car_rent.utils.DTO.CarDTO;

import java.util.List;

public interface CarService {
    Car create(CarDTO request);
    List<Car> getAll();
    Car getOne(Integer id);
    Car update(Integer id, CarDTO request);
    void delete(Integer id);
}
