package com.akcodes.swasthma.payloads.user;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class UserDto {
    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String profilePictureUrl;

    private String phoneNo;

//    private Set<Role> role = new HashSet<>();

    private Date DateOfBirth;

    private String gender;


//    private List<DoctorDetail> doctorDetail = new ArrayList<>();
////
//    private List<MotherDetail>motherDetail = new ArrayList<>();
////
//    private List<CaretakerDetail> caretakerDetail= new ArrayList<>();
}
