package ua.novoselytsia.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.novoselytsia.dao.UserDAO;
import ua.novoselytsia.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", email)
                .uniqueResultOptional();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select u from User u", User.class)
                .list();
    }

    @Override
    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select u from User u where u.id = :id",User.class)
                .setParameter("id",id)
                .uniqueResult();
    }

    @Override
    public List<User> getByFirstName(String firstName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select u from User u where u.firstName = :firstName", User.class)
                .setParameter("firstName",firstName)
                .list();
    }

    @Override
    public List<User> getByLastName(String lastName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select u from User u where u.lastName = :lastName", User.class)
                .setParameter("lastName",lastName)
                .list();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from User u where u.id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }
}
