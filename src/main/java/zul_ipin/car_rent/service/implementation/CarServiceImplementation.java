package zul_ipin.car_rent.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.repository.CarRepository;
import zul_ipin.car_rent.service.BrandService;
import zul_ipin.car_rent.service.CarService;
import zul_ipin.car_rent.utils.DTO.CarDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImplementation implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;

    @Override
    public Car create(CarDTO request) {
        Brand brand = brandService.getOne(request.getBrand_id());
        Car car = new Car();
        car.setName(request.getName());
        car.setAvailable(true);
        car.setPrice(request.getPrice());

        return carRepository.save(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getOne(Integer id) {
        return carRepository.getById(id);
    }

    @Override
    public Car update(Integer id, CarDTO request) {
        Car car = this.getOne(id);
        car.setName(request.getName());
        car.setAvailable(request.getAvailable());
        car.setPrice(request.getPrice());

        return car;
    }

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
