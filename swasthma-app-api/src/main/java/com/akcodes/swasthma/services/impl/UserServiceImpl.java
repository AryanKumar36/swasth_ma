package com.akcodes.swasthma.services.impl;

import com.akcodes.swasthma.entities.user.*;
import com.akcodes.swasthma.exceptions.ResourceNotFoundException;
import com.akcodes.swasthma.payloads.user.CaretakerDto;
import com.akcodes.swasthma.payloads.user.DoctorDto;
import com.akcodes.swasthma.payloads.user.MotherDto;
import com.akcodes.swasthma.payloads.user.UserRegistrationDto;
import com.akcodes.swasthma.repositories.*;
import com.akcodes.swasthma.services.RoleService;
import com.akcodes.swasthma.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DoctorDetailRepo doctorDetailRepo;
    @Autowired
    private MotherDetailRepo motherDetailRepo;
    @Autowired
    private CaretakerDetailRepo caretakerDetailRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public User registerUser(UserRegistrationDto userRegistrationDto) {

        User user = modelMapper.map(userRegistrationDto, User.class);

        user.setPassword(userRegistrationDto.getPassword());

        User savedUser = userRepo.save(user);

        Role userRole = roleService.findByRoleName(userRegistrationDto.getRole());
        user.setRole(userRole);


        if("doctor".equals(userRegistrationDto.getRole()))
        {
            DoctorDto doctorDto = userRegistrationDto.getDoctorDto();
            DoctorDetail doctorDetail = modelMapper.map(doctorDto, DoctorDetail.class);
            doctorDetail.setUser(user);

            doctorDetailRepo.save(doctorDetail);

        }
        else if("mother".equals(userRegistrationDto.getRole()))
        {
            MotherDto motherDto = userRegistrationDto.getMotherDto();
            MotherDetail motherDetail = modelMapper.map(motherDto, MotherDetail.class);
            motherDetail.setUser(user);

            motherDetailRepo.save(motherDetail);
        } else if ("caretaker".equals(userRegistrationDto.getRole())) {
            CaretakerDto caretakerDto = userRegistrationDto.getCaretakerDto();
            CaretakerDetail caretakerDetail = modelMapper.map(caretakerDto, CaretakerDetail.class);
            caretakerDetail.setUser(user);

            caretakerDetailRepo.save(caretakerDetail);
        }

        return user;
    }

    @Override
    public List<MotherDetail> getAllMothers() {
       return motherDetailRepo.findAll();
    }

    @Override
    public List<DoctorDetail> getAllDoctors() {
        return doctorDetailRepo.findAll();
    }

    @Override
    public List<CaretakerDetail> getAllCaretaker() {
        return caretakerDetailRepo.findAll();
    }

    @Override
    public void delete(Integer userID) {

        User user = userRepo.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("User", "user_id", userID));

        Optional<DoctorDetail> doctorDetailOptional = doctorDetailRepo.findByUserId(userID);
        Optional<MotherDetail> motherDetailOptional = motherDetailRepo.findByUserId(userID);
        Optional<CaretakerDetail> caretakerDetailOptional= caretakerDetailRepo.findByUserId(userID);


        if(doctorDetailOptional.isPresent())
        {
            DoctorDetail doctorDetail = doctorDetailOptional.get();

            doctorDetailRepo.delete(doctorDetail);
        } else if (motherDetailOptional.isPresent()) {

            MotherDetail motherDetail = motherDetailOptional.get();

            motherDetailRepo.delete(motherDetail);
        } else if (caretakerDetailOptional.isPresent()) {

            CaretakerDetail caretakerDetail = caretakerDetailOptional.get();

            caretakerDetailRepo.delete(caretakerDetail);

        }

    }


    @Override
    public void updateUser(int userId, UserRegistrationDto userRegistrationDto) {

        User user = userRepo.findById(userId)
                        .orElseThrow(()->new ResourceNotFoundException("User", "userID", userId));


        Role userRole = roleService.findByRoleName(userRegistrationDto.getRole());
        Role existingRole = user.getRole();



        if(userRole != existingRole)
        {
             throw new IllegalArgumentException("Role can't be changed");
        }
        userRepo.save(user);


//
//        if("doctor".equals(userRegistrationDto.getRole()))
//        {
//            DoctorDetail doctorDetail = doctorDetailRepo.findByUserId(userId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Doctor", "userId", userId));
//            DoctorDto doctorDetailDto = userRegistrationDto.getDoctorDto();
//
//            DoctorDetail doctorDetail1 = modelMapper.map(doctorDetailDto, DoctorDetail.class);
//
//            doctorDetail1.setUser(user);
//
//            doctorDetailRepo.save(doctorDetail1);
//        }
//        else if("mother".equals(userRegistrationDto.getRole()))
//        {
//            MotherDto motherDto = userRegistrationDto.getMotherDto();
//            MotherDetail motherDetail = modelMapper.map(motherDto, MotherDetail.class);
//            motherDetail.setUser(user);
//
//            motherDetailRepo.save(motherDetail);
//        } else if ("caretaker".equals(userRegistrationDto.getRole())) {
//            CaretakerDto caretakerDto = userRegistrationDto.getCaretakerDto();
//            CaretakerDetail caretakerDetail = modelMapper.map(caretakerDto, CaretakerDetail.class);
//            caretakerDetail.setUser(user);
//
//            caretakerDetailRepo.save(caretakerDetail);
//        }
//
//        return null;
}


}


