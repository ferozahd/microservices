package com.microservices.restaurant.controllers;

import com.microservices.restaurant.entities.User;
import com.microservices.restaurant.repositories.UserRepository;
import com.microservices.restaurant.resources.authentication.UserRegisterPostResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication/")
public class AuthenticationController {

    private final UserRepository userRepository;
    public AuthenticationController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterPostResource registerPost){

        var user =new User();
        user.setName(registerPost.getName());
        user.setEmail(registerPost.getEmail());
        user.setPassword(registerPost.getPassword());
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
