package com.akcodes.swasthma.payloads.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {
    private String speciality;
    private String experienceInYears;
    private String currentHospital;
    private Double consultationFee;
    private String medicalRecordNumber;
}
