package ua.novoselytsia.dao;

import ua.novoselytsia.entities.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAll();
    void save(Post post);
}
