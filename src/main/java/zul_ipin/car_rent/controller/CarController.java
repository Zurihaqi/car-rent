package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.service.CarService;
import zul_ipin.car_rent.utils.DTO.CarDTO;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public Car create(@RequestBody CarDTO request){
        return carService.create(request);
    }

    @GetMapping
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getOne(@PathVariable Integer id) {
        return carService.getOne(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer id, @RequestBody CarDTO request){
        return carService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carService.delete(id);
    }
}
