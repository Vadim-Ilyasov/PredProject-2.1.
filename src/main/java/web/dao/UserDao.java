package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();


    void saveUser(User user);
    void updateUser(long id, User updateUser);
    User getUserById(long id);
}
