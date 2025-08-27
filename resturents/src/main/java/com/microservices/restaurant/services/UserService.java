package com.microservices.restaurant.services;

import com.microservices.restaurant.resources.UserGetResource;
import com.microservices.restaurant.resources.authentication.UserRegisterPostResource;

import java.util.List;

public interface UserService {
    List<UserGetResource> getAllUsers();

    UserGetResource createUser(UserRegisterPostResource registerPost);
}
