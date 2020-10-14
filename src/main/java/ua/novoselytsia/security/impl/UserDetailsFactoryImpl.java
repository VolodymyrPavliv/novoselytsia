package ua.novoselytsia.security.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.novoselytsia.entities.Role;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.security.CustomerDetails;
import ua.novoselytsia.security.UserDetailsFactory;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserDetailsFactoryImpl implements UserDetailsFactory {
    private static final String ROLE_PREFIX = "ROLE_";

    public UserDetails create(User user) {
        return new CustomerDetails(user.getEmail(), user.getPassword(), user.getId(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()))
                .collect(Collectors.toList());
    }

}
