package com.microservices.restaurant.controllers.impl;

import com.microservices.restaurant.controllers.AuthenticationController;
import com.microservices.restaurant.entities.User;
import com.microservices.restaurant.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {

    private final UserService userService;


//    @PostMapping("register")
//    public ResponseEntity<?> registerUser(@RequestBody UserRegisterPostResource registerPost){
//
//        var user =new User();
//        user.setName(registerPost.getName());
//        user.setEmail(registerPost.getEmail());
//        user.setPassword(passwordEncoder.encode(registerPost.getPassword()));
//        userRepository.save(user);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }

    @Override
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("All users get request");
        var users=userRepository.findAll();
        return ResponseEntity.ok(userService.findAll());
    }
}
