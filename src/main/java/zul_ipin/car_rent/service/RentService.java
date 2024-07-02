package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.Rent;
import zul_ipin.car_rent.utils.DTO.RentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentService {
    Rent create(RentDTO request);
    Page<Rent> getAll(Pageable pageable);
    Rent getOne(Integer id);
    Rent update(Integer id);
    void delete(Integer id);
}
