package ua.novoselytsia.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.novoselytsia.dao.PostDAO;
import ua.novoselytsia.entities.Post;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {
    private SessionFactory sessionFactory;

    public PostDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Post> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Post p", Post.class)
                .list();
    }

    @Override
    public List<Post> getByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Post p where p.title =:title", Post.class)
                .setParameter("title",title)
                .list();
    }

    @Override
    public List<Post> getByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Post p where p.user.id =:userId", Post.class)
                .setParameter("userId",userId)
                .list();
    }

    @Override
    public void save(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(post);
    }

    @Override
    public Post getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Post p where p.id =:id",Post.class)
                .setParameter("id",id)
                .uniqueResult();
    }

    @Override
    public List<Post> getByUserIdAndTitle(Long userId, String title) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Post p where p.user.id = :userId and p.title =:title", Post.class)
                .setParameter("userId", userId)
                .setParameter("title", title)
                .list();
    }

    @Override
    public void delete(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(post);
    }
}
