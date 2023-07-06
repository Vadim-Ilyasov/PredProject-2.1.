package web.dao;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

//    @Override
//    public void updateUser(long id, User updateUser) {
//        User user = entityManager.find(User.class, id);
//        user.setName(updateUser.getName());
//        user.setSurname(updateUser.getSurname());
//        user.setAge(updateUser.getAge());
//        user.setEmail(updateUser.getEmail());
//        entityManager.persist(user);
//    }

    @Override
    public User getUserById(long id) {
//        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


}
