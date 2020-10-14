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

    @Override
    public List<Post> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Post p", Post.class)
                .list();
    }

    @Override
    public void save(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(post);
    }
}
