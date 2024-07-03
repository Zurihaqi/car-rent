package zul_ipin.car_rent.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zul_ipin.car_rent.utils.Res;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e){
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if(message.contains("name") && message.contains("model.Brand")){
            message = "Brand name cannot be blank!";
        }
        if(message.contains("name") && message.contains("model.Car")){
            message = "Car name cannot be blank!";
        }
        if(message.contains("price") && message.contains("model.Car")){
            message = "Car price cannot be blank!";
        }
        if(message.contains("name") && message.contains("model.User")){
            message = "User name cannot be blank!";
        }
        if(message.contains("balance") && message.contains("model.User")){
            message = "Balance cannot be blank!";
        }

        return Res.renderJson(null, message, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e){
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if(message.contains("Brand with id")){
            message = "Brand not found!";
        }
        if(message.contains("Car with id")){
            message = "Car not found!";
        }
        if(message.contains("startedTemp")){
            message = "Rent started_at cannot be blank!";
        }
        if(message.contains("endsTemp")){
            message = "Rent ends_at cannot be blank!";
        }
        if(message.contains("Car is not available")){
            message = "Car is not available for rent!";
        }
        if(message.contains("user_id empty")){
            message = "Rent user_id cannot be blank";
        }
        if(message.contains("car_id empty")){
            message = "Rent car_id cannot be blank";
        }
        if(message.contains("brand_id empty")){
            message = "Car brand_id cannot be blank";
        }

        return Res.renderJson(null, message, status);
    }
}
