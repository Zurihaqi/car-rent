package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public Brand create(@RequestBody Brand request){
        return brandService.create(request);
    }

    @GetMapping
    public List<Brand> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public Brand getOne(@PathVariable Integer id) {
        return brandService.getOne(id);
    }

    @PutMapping
    public Brand update(@RequestBody Brand request){
        return brandService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        brandService.delete(id);
    }
}
