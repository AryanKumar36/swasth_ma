package com.akcodes.swasthma.controllers;

import com.akcodes.swasthma.entities.user.CaretakerDetail;
import com.akcodes.swasthma.entities.user.DoctorDetail;
import com.akcodes.swasthma.entities.user.MotherDetail;
import com.akcodes.swasthma.entities.user.User;
import com.akcodes.swasthma.payloads.ApiResponse;
import com.akcodes.swasthma.payloads.user.UserRegistrationDto;
import com.akcodes.swasthma.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto)
    {
        User user = userService.registerUser(userRegistrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/mothers")
    public ResponseEntity<?> getAllMothers()
    {
        List<MotherDetail> motherDetails = userService.getAllMothers();
        return ResponseEntity.ok(motherDetails);
    }

    @GetMapping("/doctors")
    public ResponseEntity<?> getAllDoctors()
    {
        List<DoctorDetail> doctorDetails = userService.getAllDoctors();
        return ResponseEntity.ok(doctorDetails);
    }

    @GetMapping("/caretaker")
    public ResponseEntity<?> getAllCaretakers()
    {
        List<CaretakerDetail> caretakerDetails = userService.getAllCaretaker();
        return ResponseEntity.ok(caretakerDetails);
    }

    //Delete Mapping
    @DeleteMapping("/{userID}")
    public ApiResponse deleteUser(@PathVariable int userID){

     userService.delete(userID);
     return new ApiResponse("User is successfully Deleted !!" , true);
    }


    @PutMapping("/{userID}")
    public ResponseEntity<?> updateTesting(@PathVariable int userID
            ,@RequestBody UserRegistrationDto userRegistrationDto)
    {
        userService.updateUser(userID, userRegistrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");
    }

}


















