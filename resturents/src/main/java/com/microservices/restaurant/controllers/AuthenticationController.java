package com.microservices.restaurant.controllers;

import com.microservices.restaurant.entities.User;
import com.microservices.restaurant.repositories.UserRepository;
import com.microservices.restaurant.resources.authentication.UserRegisterPostResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authentication/")
public class AuthenticationController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public AuthenticationController(UserRepository userRepository,
                                    PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterPostResource registerPost){

        var user =new User();
        user.setName(registerPost.getName());
        user.setEmail(registerPost.getEmail());
        user.setPassword(passwordEncoder.encode(registerPost.getPassword()));
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("all-users")
    public ResponseEntity<List<User>> getAllUsers(){
        var users=userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
