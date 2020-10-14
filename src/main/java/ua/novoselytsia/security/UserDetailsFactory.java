package ua.novoselytsia.security;

import org.springframework.security.core.userdetails.UserDetails;
import ua.novoselytsia.entities.User;

public interface UserDetailsFactory {
    UserDetails create(User user);
}
