package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.service.CarService;
import zul_ipin.car_rent.utils.DTO.CarDTO;
import zul_ipin.car_rent.utils.PageResponWrapper;
import zul_ipin.car_rent.utils.Res;

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
    public ResponseEntity<?> getAll(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean available
    ) {
        Page<Car> res = carService.getAll(pageable, name, available);
        PageResponWrapper<Car> result = new PageResponWrapper<>(res);
        return Res.renderJson(
                result,
                "Data Found!",
                HttpStatus.OK
        );
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
