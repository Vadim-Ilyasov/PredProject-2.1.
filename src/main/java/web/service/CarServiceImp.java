package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
@Component
public class CarServiceImp implements CarService {
    CarDao carDao;
    @Override
    public List<Car> getCountCars(List<Car> cars, int count) {
        return carDao.getCountCars(cars, count);
    }
}
