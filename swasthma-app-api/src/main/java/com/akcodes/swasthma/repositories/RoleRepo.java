package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRoleName(String name);
}
