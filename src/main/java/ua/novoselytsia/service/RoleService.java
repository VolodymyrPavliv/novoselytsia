package ua.novoselytsia.service;

import ua.novoselytsia.entities.Role;

public interface RoleService {
    Role getByName(String name);
}
