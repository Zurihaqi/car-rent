package zul_ipin.car_rent.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.repository.BrandRepository;
import zul_ipin.car_rent.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zul_ipin.car_rent.utils.spesification.BrandSpesification;


@Service
@RequiredArgsConstructor
public class BrandServiceImplementation implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand request){
        return brandRepository.save(request);
    }

    @Override
    public Page<Brand> getAll(Pageable pageable, String name){
        Specification<Brand> spec = BrandSpesification.getSpesification(name);
        return brandRepository.findAll(spec, pageable);
    }

    @Override
    public Brand getOne(Integer id){
        return brandRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Brand with id " + id + " not found!"));
    }

    @Override
    public Brand update(Integer id, Brand request){
        Brand brand = this.getOne(id);
        brand.setName(request.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id){
        brandRepository.deleteById(id);
    }
}
