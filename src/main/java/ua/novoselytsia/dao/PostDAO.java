package ua.novoselytsia.dao;

import ua.novoselytsia.entities.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAll();
    Post getById(Long id);
    List<Post> getByTitle(String title);
    List<Post> getByUserId(Long userId);
    List<Post> getByUserIdAndTitle(Long userId, String title);
    void delete(Post post);
    void save(Post post);
}
