package com.akcodes.swasthma.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
@Table(name = "doctor_detail")
public class DoctorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User user;

    @NotBlank(message = "Speciality is mandatory")
    @Size(max = 100, message = "Speciality cannot exceed 100 characters")
    private String speciality;

    private String experienceInYears;

    @NotBlank(message = "Current Hospital is mandatory")
    @Size(max = 255, message = "Current Hospital cannot exceed 255 characters")
    private String currentHospital;

    private Double consultationFee;

    @NotBlank(message = "MRN is mandatory")
    @Column(unique = true)
    private String medicalRecordNumber;

}