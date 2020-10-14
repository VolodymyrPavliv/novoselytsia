package ua.novoselytsia.service;

import ua.novoselytsia.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    void save(Post post);
}
