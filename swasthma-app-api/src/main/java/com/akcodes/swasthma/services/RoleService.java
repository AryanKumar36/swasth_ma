package com.akcodes.swasthma.services;

import com.akcodes.swasthma.entities.user.Role;

public interface RoleService {

    public Role findByRoleName(String roleName);

}
