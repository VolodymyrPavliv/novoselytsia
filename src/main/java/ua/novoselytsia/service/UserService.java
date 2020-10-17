package ua.novoselytsia.service;

import ua.novoselytsia.entities.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void register(User user);
    User getByEmail(String email);
    List<User> getAll();
    User getById(Long id);
    List<User> getByLastName(String lastName);
    void changeRole(User user);
    void delete(Long id);
}
