package com.akcodes.swasthma.services;

import com.akcodes.swasthma.entities.user.CaretakerDetail;
import com.akcodes.swasthma.entities.user.DoctorDetail;
import com.akcodes.swasthma.entities.user.MotherDetail;
import com.akcodes.swasthma.entities.user.User;
import com.akcodes.swasthma.payloads.user.UserRegistrationDto;

import java.util.List;

public interface UserService {

      //Register(POST)
      User registerUser(UserRegistrationDto userRegistrationDto);

      //GET
      List<MotherDetail> getAllMothers();

      List<DoctorDetail> getAllDoctors();

      List<CaretakerDetail> getAllCaretaker();

      //Delete By User Id
      void delete(Integer userID);

      void updateUser(int userId, UserRegistrationDto userRegistrationDto);


}
