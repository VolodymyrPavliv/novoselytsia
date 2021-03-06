package ua.novoselytsia.service;

import ua.novoselytsia.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post getById(Long id);
    List<Post> getByTitle(String title);
    List<Post> getByUserId(Long userId);
    List<Post> getByUserIdAndTitle(Long userId, String title);
    void save(Post post);
    void delete(Post post);
}
