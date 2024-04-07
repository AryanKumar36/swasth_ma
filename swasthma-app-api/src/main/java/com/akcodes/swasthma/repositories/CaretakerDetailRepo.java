package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.user.CaretakerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CaretakerDetailRepo extends JpaRepository<CaretakerDetail, Integer> {
    @Query("SELECT d FROM CaretakerDetail d WHERE d.user.id = :userId")
    Optional<CaretakerDetail> findByUserId(Integer userId);
}
