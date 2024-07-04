package zul_ipin.car_rent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zul_ipin.car_rent.model.User;
import zul_ipin.car_rent.service.UserService;
import zul_ipin.car_rent.utils.PageResponWrapper;
import zul_ipin.car_rent.utils.Res;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User request){
        User result = userService.create(request);
        return Res.renderJson(
                result,
                "Data Has Been Created!",
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String name
    ) {
        Page<User> res = userService.getAll(pageable, name);
        PageResponWrapper<User> result = new PageResponWrapper<>(res);
        return Res.renderJson(
                result,
                result.getTotalElements() == 0 ? "Data Empty!" : "Data Found!",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        User result = userService.getOne(id);
        return Res.renderJson(
                result,
                "Data Found!",
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User request){
        User result = userService.update(id, request);
        return Res.renderJson(
                result,
                "Data Has Been Updated!",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return Res.renderJson(
                null,
                "Data Has Been Deleted!",
                HttpStatus.OK
        );
    }

    @PostMapping("/topup/{id}")
    public ResponseEntity<?> topUp(@PathVariable Integer id, @RequestBody User request){
        User result = userService.topUp(id, request);
        return Res.renderJson(
                result,
                "Balance Has Been Updated!",
                HttpStatus.OK
        );
    }
}
