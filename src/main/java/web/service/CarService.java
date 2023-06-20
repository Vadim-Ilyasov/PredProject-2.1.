package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCountCars(List<Car> cars, int count);
}
