package ua.novoselytsia.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.novoselytsia.dao.PostDAO;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.security.CustomerDetails;
import ua.novoselytsia.service.PostService;
import ua.novoselytsia.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final UserService userService;

    public PostServiceImpl(PostDAO postDAO, UserService userService) {
        this.postDAO = postDAO;
        this.userService = userService;
    }

    @Override
    @Transactional
    public List<Post> getAll() {
        return postDAO.getAll();
    }

    @Override
    @Transactional
    public List<Post> getByTitle(String title) {
        if(title.isEmpty())
            return getAll();
        return postDAO.getByTitle(title);
    }

    @Override
    @Transactional
    public List<Post> getByUserId(Long userId) {
        return postDAO.getByUserId(userId);
    }

    @Override
    @Transactional
    public List<Post> getByUserIdAndTitle(Long userId, String title) {
        if(title.isEmpty())
            return getByUserId(userId);
        return postDAO.getByUserIdAndTitle(userId, title);
    }

    @Override
    @Transactional
    public void save(Post post) {
        postDAO.save(post);
    }

    @Override
    @Transactional
    public Post getById(Long id) {
        return postDAO.getById(id);
    }

    @Override
    @Transactional
    public void delete(Post post) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User currentUser = userService.getById(customerDetails.getUserId());
        if(post.getUser() == currentUser || currentUser.getRoles().stream()
        .anyMatch(role -> role.getName().equals("MANAGER"))) {
            postDAO.delete(post);
        }
    }
}
