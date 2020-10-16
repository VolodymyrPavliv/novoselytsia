package ua.novoselytsia.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.novoselytsia.dao.UserDAO;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.service.RoleService;
import ua.novoselytsia.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void save(User user) {
        if(user.getRoles().isEmpty()) {
            encodeUsersPassword(user);
            user.setRoles(new ArrayList<>());
            user.getRoles().add(roleService.getByName("CUSTOMER"));
        }
        userDAO.save(user);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public User getByEmail(String email) {
        return userDAO.getByEmail(email).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }

    private void encodeUsersPassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
