package ua.novoselytsia.dao;

import ua.novoselytsia.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    Optional<User> getByEmail(String email);
    List<User> getByFirstName(String firstName);
    List<User> getByLastName(String lastName);
    void save(User user);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
}
