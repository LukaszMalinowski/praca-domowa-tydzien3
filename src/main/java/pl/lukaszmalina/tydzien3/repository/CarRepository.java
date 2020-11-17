package pl.lukaszmalina.tydzien3.repository;

import org.springframework.stereotype.Repository;
import pl.lukaszmalina.tydzien3.entity.Car;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

    private List<Car> carList;

    public CarRepository() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCars() {
        return carList;
    }

    public Optional<Car> getCarById(long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    public List<Car> getCarsByColor(String color) {
        return carList.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
    }

    public boolean addCar(Car car) {
        return carList.add(car);
    }

    public boolean editCar(Car newCar) {
        Optional<Car> optionalCar = carList.stream().filter(oldCar -> oldCar.getId() == newCar.getId()).findFirst();

        if (optionalCar.isPresent()) {
            carList.remove(optionalCar.get());
            carList.add(newCar);
            return true;
        }

        return false;
    }

    public boolean removeCarById(long id) {
        Optional<Car> optionalCar = carList.stream().filter(oldCar -> oldCar.getId() == id).findFirst();

        if(optionalCar.isPresent()) {
            carList.remove(optionalCar.get());
            return true;
        }

        return false;
    }
}
