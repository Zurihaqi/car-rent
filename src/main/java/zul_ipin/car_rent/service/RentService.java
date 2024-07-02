package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.Rent;
import zul_ipin.car_rent.utils.DTO.RentDTO;

import java.util.List;

public interface RentService {
    Rent create(RentDTO request);
    List<Rent> getAll();
    Rent getOne(Integer id);
    Rent update(Integer id);
    void delete(Integer id);
}
