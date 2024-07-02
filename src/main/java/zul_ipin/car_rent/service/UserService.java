package zul_ipin.car_rent.service;

import zul_ipin.car_rent.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User create(User request);
    Page<User> getAll(Pageable pageable);
    User getOne(Integer id);
    User update(Integer id, User request);
    void delete(Integer id);
    User topUp(Integer id, User request);
}
