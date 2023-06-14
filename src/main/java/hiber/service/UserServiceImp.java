package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user, Car cars) {
        userDao.add(user, cars);

    }


    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    public List<Car> listCars() {
        return userDao.listCars();
    }


    @Override
    public User getUsersByModelAndSeries(String model, int series) {
        return userDao.getUsersByModelAndSeries(model, series);
    }

}
