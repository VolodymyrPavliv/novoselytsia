package ua.novoselytsia.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.novoselytsia.dao.PlaceDAO;
import ua.novoselytsia.entities.Place;

import java.util.List;

@Repository
public class PlaceDAOImpl implements PlaceDAO {
    private final SessionFactory sessionFactory;

    public PlaceDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Place> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Place p",Place.class)
                .list();
    }

    @Override
    public List<Place> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Place p where p.name = :name",Place.class)
                .setParameter("name",name)
                .list();
    }

    @Override
    public Place getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Place p where p.id = :id",Place.class)
                .setParameter("id",id)
                .uniqueResult();
    }

    @Override
    public void delete(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(place);
    }

    @Override
    public void save(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(place);
    }
}
