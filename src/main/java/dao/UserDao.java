package dao;

import entity.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {

    private SessionFactory sessionFactory;
    private EntityManager entityManager;

    protected UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User getUserByLoginAndPassword(String login, String password) {
        User user;
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        user = entityManager
                .createQuery("SELECT u from entity.User u WHERE u.login =:login and u.password =:password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList()
                .get(0);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public void createUser(User user) {
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAll() {
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from entity.User", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }
}
