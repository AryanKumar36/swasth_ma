package com.akcodes.swasthma.services;

import com.akcodes.swasthma.entities.user.Role;
import com.akcodes.swasthma.repositories.RoleRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDataInitializer {
    @Autowired
    private RoleRepo roleRepository;

    @PostConstruct
    public void init() {
        // Check if the role table is empty
        if (roleRepository.count() == 0) {
            // Populate the role table with initial data
            Role roleMother = new Role();
            roleMother.setRoleName("mother");
            roleRepository.save(roleMother);

            Role roleDoctor = new Role();
            roleDoctor.setRoleName("doctor");
            roleRepository.save(roleDoctor);

            Role roleCaretaker = new Role();
            roleCaretaker.setRoleName("caretaker");
            roleRepository.save(roleCaretaker);
        }
    }
}
