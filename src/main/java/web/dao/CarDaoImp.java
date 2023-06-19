package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarDaoImp implements CarDao {



    @Override
    public  List<Car> getCountCars(List<Car> cars, int count) {
        if (count == 0 || count > 5)
            return cars;
        return cars.stream().limit(count).collect(Collectors.toList());
    }

}


