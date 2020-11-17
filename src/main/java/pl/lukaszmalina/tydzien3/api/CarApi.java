package pl.lukaszmalina.tydzien3.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lukaszmalina.tydzien3.entity.Car;
import pl.lukaszmalina.tydzien3.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarApi {

    CarService service;

    @Autowired
    public CarApi(CarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = service.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Optional<Car> car = service.getCarById(id);

        if(car.isPresent())
            return new ResponseEntity<>(car.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{color}")
    public ResponseEntity<List<Car>> getCarsByColor(@PathVariable String color) {
        List<Car> cars = service.getCarsByColor(color);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCar(@Validated @RequestBody Car car) {
        boolean isAdded = service.addCar(car);

        if(isAdded)
            return new ResponseEntity(HttpStatus.CREATED);

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO modyfikowanie, modyfikowanie jednego z pól, usuwanie


}
