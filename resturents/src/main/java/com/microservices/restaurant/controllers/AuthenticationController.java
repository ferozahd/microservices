package com.microservices.restaurant.controllers;

import com.microservices.restaurant.entities.User;
import com.microservices.restaurant.resources.UserGetResource;
import com.microservices.restaurant.resources.authentication.UserRegisterPostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("authentication")
public interface AuthenticationController {

    @PostMapping("register")
    ResponseEntity<?> registerUser(@RequestBody UserRegisterPostResource registerPost);


    @GetMapping("/all-users")
    ResponseEntity<List<UserGetResource>> getAllUsers();
}
