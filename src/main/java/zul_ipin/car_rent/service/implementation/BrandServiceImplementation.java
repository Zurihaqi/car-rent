package zul_ipin.car_rent.service.implementation;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.Brand;
import zul_ipin.car_rent.repository.BrandRepository;
import zul_ipin.car_rent.service.BrandService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImplementation implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand request){
        return brandRepository.save(request);
    }

    @Override
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @Override
    public Brand getOne(Integer id){
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand update(Brand request){
        Brand brand = this.getOne(request.getId());
        brand.setName(request.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id){
        brandRepository.deleteById(id);
    }
}
