package zul_ipin.car_rent.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zul_ipin.car_rent.model.Car;
import zul_ipin.car_rent.model.Rent;
import zul_ipin.car_rent.model.User;
import zul_ipin.car_rent.repository.RentRepository;
import zul_ipin.car_rent.service.CarService;
import zul_ipin.car_rent.service.RentService;
import zul_ipin.car_rent.service.UserService;
import zul_ipin.car_rent.utils.DTO.CarDTO;
import zul_ipin.car_rent.utils.DTO.RentDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RentServiceImplementation implements RentService {
    private final RentRepository rentRepository;
    private final CarService carService;
    private final UserService userService;

    @Override
    public Rent create(RentDTO request) {
        Car car = carService.getOne(request.getCar_id());
        User user = userService.getOne(request.getUser_id());
        Rent newRent = new Rent();

        if(!car.getAvailable()) return null;

        car.setAvailable(false);

        newRent.setCar(car);
        newRent.setUser(user);
        newRent.setCompleted(false);

        // Hitung price * hari pinjam
        Date startedTemp = request.getStarted_at();
        Date endsTemp = request.getEnds_at();
        long diff = endsTemp.getTime() - startedTemp.getTime();
        long daysDifference = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        int rentPrice = (int) (car.getPrice() * daysDifference);

        user.setBalance(user.getBalance() - rentPrice / 2);

        newRent.setStartedAt(request.getStarted_at());
        newRent.setEndsAt(request.getEnds_at());
        newRent.setRentPrice(rentPrice);

        return rentRepository.save(newRent);
    }

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getOne(Integer id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public Rent update(Integer id) {
        Rent rent = rentRepository.findById(id).orElse(null);
        assert rent != null;
        User user = userService.getOne(rent.getUser().getId());
        Car car = carService.getOne(rent.getCar().getId());

        Date endsTemp = rent.getEndsAt();
        Date completeDate = new Date();
        long diff = endsTemp.getTime() - completeDate.getTime();
        long daysDifference = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        int rentPrice = (int) (car.getPrice() * daysDifference);

        // Jika lewat batas akhir denda 10% dari harga rental
        if(daysDifference < 0){
            rentPrice += rentPrice * 10 / 100;
        }

        user.setBalance(user.getBalance() - rentPrice / 2);
        car.setAvailable(true);
        rent.setCompleted(true);

        return rentRepository.save(rent);
    }

    @Override
    public void delete(Integer id) {
        Rent temp = rentRepository.getById(id);
        Car car = carService.getOne(temp.getCar().getId());
        car.setAvailable(true);
        rentRepository.deleteById(id);
    }
}
