package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.User;
import zul_ipin.car_rent.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User request){
        return userService.create(request);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id){
        return userService.getOne(id);
    }

    @PutMapping
    public User update(@PathVariable Integer id, @RequestBody User request){
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
}
