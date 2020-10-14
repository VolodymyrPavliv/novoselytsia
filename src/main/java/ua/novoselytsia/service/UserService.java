package ua.novoselytsia.service;

import ua.novoselytsia.entities.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User getByEmail(String email);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
}
