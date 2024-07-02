package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Rent;
import zul_ipin.car_rent.service.RentService;
import zul_ipin.car_rent.utils.DTO.RentDTO;

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
    public List<Rent> getAll(){
        return rentService.getAll();
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
