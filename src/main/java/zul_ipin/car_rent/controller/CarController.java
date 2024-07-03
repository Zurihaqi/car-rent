package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.service.CarService;
import zul_ipin.car_rent.utils.DTO.CarDTO;
import zul_ipin.car_rent.utils.PageResponWrapper;
import zul_ipin.car_rent.utils.Res;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CarDTO request){
        Car result = carService.create(request);
        return Res.renderJson(
                result,
                "Data Has Been Created!",
                HttpStatus.OK
        );
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
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Car result = carService.getOne(id);
        return Res.renderJson(
                result,
                "Data Found!",
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CarDTO request){
        Car result = carService.update(id, request);
        return Res.renderJson(
                result,
                "Data Has Been Updated!",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        carService.delete(id);
        return Res.renderJson(
                null,
                "Data Has Been Deleted!",
                HttpStatus.OK
        );
    }
}
