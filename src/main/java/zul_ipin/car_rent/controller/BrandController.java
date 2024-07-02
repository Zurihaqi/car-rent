package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.service.BrandService;
import zul_ipin.car_rent.utils.PageResponWrapper;
import zul_ipin.car_rent.utils.Res;

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
    public ResponseEntity<?> getAll(
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Brand> res = brandService.getAll(pageable);
        PageResponWrapper<Brand> result = new PageResponWrapper(res);
        return Res.renderJson(
                result,
                "Data Found!",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Brand getOne(@PathVariable Integer id) {
        return brandService.getOne(id);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody Brand request){
        return brandService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        brandService.delete(id);
    }
}
