package zul_ipin.car_rent.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zul_ipin.car_rent.model.Brand;

public interface BrandService {
    Brand create(Brand request);
    Page<Brand> getAll(Pageable pageable, String name);
    Brand getOne(Integer id);
    Brand update(Integer id, Brand request);
    void delete(Integer id);
}
