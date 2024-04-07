package com.akcodes.swasthma.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mother_detail")
public class MotherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long motherId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Max(message = "Invalid range for week", value = 48)
    @Min(message = "Invalid range for week", value = 1)
    @Positive(message = "Week can not be negative")
    @Column(nullable = false)
    private int weekOfPregnancy;

    @NotBlank(message = "Blood Group can not be empty")
    private String bloodGroup;

    @NotBlank(message = "emergency no. can not be empty")
    private String emergencyNumber;

}