package com.microservices.restaurant.controllers.impl;

import com.microservices.restaurant.controllers.AuthenticationController;
import com.microservices.restaurant.entities.User;
import com.microservices.restaurant.resources.UserGetResource;
import com.microservices.restaurant.resources.authentication.UserRegisterPostResource;
import com.microservices.restaurant.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {

    private final UserService userService;


    @Override
    public ResponseEntity<UserGetResource> registerUser(@RequestBody UserRegisterPostResource registerPost){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(registerPost));
    }

    @Override
    public ResponseEntity<List<UserGetResource>> getAllUsers(){
        log.info("All users get request");

        return ResponseEntity.ok(userService.getAllUsers());
    }
}
