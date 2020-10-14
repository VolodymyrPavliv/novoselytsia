package ua.novoselytsia.dao;

import ua.novoselytsia.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    Optional<User> getByEmail(String email);
    void save(User user);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
}
