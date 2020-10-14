package ua.novoselytsia.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.novoselytsia.dao.UserDAO;
import ua.novoselytsia.entities.User;

import java.util.Optional;

@Service
@Transactional
public class CustomerDetailsService implements UserDetailsService {
    private final UserDAO userDAO;
    private final UserDetailsFactory userDetailsFactory;

    public CustomerDetailsService(UserDAO userDAO, UserDetailsFactory userDetailsFactory) {
        this.userDAO = userDAO;
        this.userDetailsFactory = userDetailsFactory;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> foundUser = userDAO.getByEmail(email);
        if (!foundUser.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        User userToLoad = foundUser.get();
        return userDetailsFactory.create(userToLoad);
    }

}
