package ua.novoselytsia.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.novoselytsia.dao.PostDAO;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostDAO postDAO;

    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
    @Override
    @Transactional
    public List<Post> getAll() {
        return postDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Post post) {
        postDAO.save(post);
    }
}
