package com.akcodes.swasthma.services.impl;

import com.akcodes.swasthma.entities.user.Role;
import com.akcodes.swasthma.repositories.RoleRepo;
import com.akcodes.swasthma.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepo.findByRoleName(roleName);
    }
}
