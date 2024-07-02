package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.model.User;

import java.util.List;

public interface CarService {
    Car create(Car request);
    List<Car> getAll();
    Car getOne(Integer id);
    Car update(Integer id, Car request);
    void delete(Integer id);
}
