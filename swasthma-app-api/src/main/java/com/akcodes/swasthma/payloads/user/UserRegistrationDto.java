package com.akcodes.swasthma.payloads.user;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserRegistrationDto {

    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String firstName;


    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @Size(max = 255)
    @Column(length = 255)
    private String profilePictureUrl;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNo;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfBirth", nullable = false)
    private Date DateOfBirth;

    @NotBlank
    @Size(max = 10)
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    private String role;

    private DoctorDto doctorDto;

    private MotherDto motherDto;

    private CaretakerDto caretakerDto;
}
