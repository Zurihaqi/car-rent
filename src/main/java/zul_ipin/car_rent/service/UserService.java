package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.User;

import java.util.List;

public interface UserService {
    User create(User request);
    List<User> getAll();
    User getOne(Integer id);
    User update(Integer id, User request);
    void delete(Integer id);
    User topUp(Integer id, User request);
}
