package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.Brand;

import java.util.List;

public interface BrandService {
    Brand create(Brand request);
    List<Brand> getAll();
    Brand getOne(Integer id);
    Brand update(Integer id, Brand request);
    void delete(Integer id);
}
