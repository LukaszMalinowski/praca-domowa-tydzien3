package pl.lukaszmalina.tydzien3.service;

import pl.lukaszmalina.tydzien3.entity.Car;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(long id);

    List<Car> getCarsByColor(String color);

    boolean addCar(Car car);

    boolean editCar(Car car);

    boolean removeCarById(long id);
}
