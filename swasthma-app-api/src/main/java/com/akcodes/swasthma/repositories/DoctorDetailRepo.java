package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.user.DoctorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DoctorDetailRepo extends JpaRepository<DoctorDetail, Integer> {

    @Query("SELECT d FROM DoctorDetail d WHERE d.user.id = :userId")
    Optional<DoctorDetail> findByUserId(Integer userId);
}
