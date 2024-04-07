package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.user.MotherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MotherDetailRepo extends JpaRepository<MotherDetail, Integer> {

    @Query("SELECT d FROM MotherDetail d WHERE d.user.id = :userId")
    Optional<MotherDetail> findByUserId(Integer userId);
}
