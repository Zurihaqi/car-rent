package zul_ipin.car_rent.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.User;
import zul_ipin.car_rent.repository.UserRepository;
import zul_ipin.car_rent.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zul_ipin.car_rent.utils.specification.UserSpecification;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User request) {
        return userRepository.save(request);
    }

    @Override
    public Page<User> getAll(Pageable pageable, String name) {
        Specification<User> spec = UserSpecification.getSpecification(name);
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User with id " + id + " not found!"));
    }

    @Override
    public User update(Integer id, User request) {
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("Car with id " + id + " not found!");
        }
        else {
            User user = this.getOne(id);
            user.setName(request.getName());
            user.setBalance(request.getBalance());

            return userRepository.save(user);
        }
    }

    @Override
    public void delete(Integer id) {
        if(userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("User with id " + id + " not found!");
        }
        else{
            userRepository.deleteById(id);
        }
    }

    @Override
    public User topUp(Integer id, User request) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("User with id " + id + " not found!");
        } else {
            User user = this.getOne(id);
            user.setBalance(user.getBalance() + request.getBalance());
            return userRepository.save(user);
        }
    }
}
