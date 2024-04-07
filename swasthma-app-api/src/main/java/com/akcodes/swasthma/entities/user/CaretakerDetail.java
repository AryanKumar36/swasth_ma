package com.akcodes.swasthma.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "caretaker_detail")
public class CaretakerDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caretakerId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String payScale;
    @NotBlank(message = "Government ID is mandatory")
    @Size(max = 50, message = "Government ID cannot exceed 50 characters")
    private String govtId;




}