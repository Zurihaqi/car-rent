package zul_ipin.car_rent.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.User;
import zul_ipin.car_rent.repository.UserRepository;
import zul_ipin.car_rent.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User request) {
        return userRepository.save(request);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(Integer id, User request) {
        User user = this.getOne(id);
        user.setName(request.getName());
        user.setBalance(request.getBalance());

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User topUp(Integer id, User request) {
        User user = this.getOne(id);
        user.setBalance(user.getBalance() + request.getBalance());

        return userRepository.save(user);
    }
}
