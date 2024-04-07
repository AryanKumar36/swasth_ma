package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.post.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
