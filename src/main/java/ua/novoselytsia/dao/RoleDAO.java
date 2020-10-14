package ua.novoselytsia.dao;

import ua.novoselytsia.entities.Role;

public interface RoleDAO {
    Role getByName(String name);
}
