package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.model.Rent;
import zul_ipin.car_rent.service.RentService;
import zul_ipin.car_rent.utils.DTO.RentDTO;
import zul_ipin.car_rent.utils.PageResponWrapper;
import zul_ipin.car_rent.utils.Res;

import java.util.List;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;

    @PostMapping
    public Rent create(@RequestBody RentDTO request){
        return rentService.create(request);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Rent> res = rentService.getAll(pageable);
        PageResponWrapper<Rent> result = new PageResponWrapper<>(res);
        return Res.renderJson(
                result,
                "Data Found!",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Rent getOne(@PathVariable Integer id){
        return rentService.getOne(id);
    }

    @PutMapping("/{id}")
    public Rent update(@PathVariable Integer id){
        return rentService.update(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        rentService.delete(id);
    }
}
