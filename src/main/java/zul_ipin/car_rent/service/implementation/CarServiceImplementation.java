package zul_ipin.car_rent.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.repository.CarRepository;
import zul_ipin.car_rent.service.BrandService;
import zul_ipin.car_rent.service.CarService;
import zul_ipin.car_rent.utils.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zul_ipin.car_rent.utils.specification.CarSpecification;

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
        car.setBrand(brand);

        return carRepository.save(car);
    }

    @Override
    public Page<Car> getAll(Pageable pageable, String name, Boolean available) {
        Specification<Car> spec = CarSpecification.getSpecification(name, available);
        return carRepository.findAll(spec, pageable);
    }

    @Override
    public Car getOne(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car update(Integer id, CarDTO request) {
        Car car = this.getOne(id);
        car.setName(request.getName());
        car.setBrand(brandService.getOne(request.getBrand_id()));
        car.setAvailable(request.getAvailable());
        car.setPrice(request.getPrice());

        return carRepository.save(car);
    }

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
