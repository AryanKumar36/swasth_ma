package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
