package web.dao;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarDao {



    public   List<Car> getCountCars(List<Car> cars, int count);

}
