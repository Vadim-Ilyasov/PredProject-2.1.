package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

     private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5")int count ,Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mercedes", 8, 478000));
        cars.add(new Car("BMV", 5, 19000));
        cars.add(new Car("Honda", 6, 8000));
        cars.add(new Car("Toyota", 5, 13000));
        cars.add(new Car("Mazda", 7, 9000));
        cars = carService.getCountCars(cars, count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}

