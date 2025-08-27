package com.microservices.restaurant.controllers;

import com.microservices.restaurant.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("authentication")
public interface AuthenticationController {

    @GetMapping("/all-users")
    ResponseEntity<List<User>> getAllUsers();
}
