package ua.novoselytsia.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.novoselytsia.dao.RoleDAO;
import ua.novoselytsia.entities.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private final SessionFactory sessionFactory;

    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from Role r where r.name=:name",Role.class)
                .setParameter("name",name)
                .uniqueResult();
    }
}
