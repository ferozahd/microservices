package com.microservices.restaurant.services.impl;

import com.microservices.restaurant.entities.User;
import com.microservices.restaurant.exceptions.RequiredFieldException;
import com.microservices.restaurant.exceptions.UserAlreadyExistsException;
import com.microservices.restaurant.repositories.UserRepository;
import com.microservices.restaurant.resources.UserGetResource;
import com.microservices.restaurant.resources.authentication.UserRegisterPostResource;
import com.microservices.restaurant.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserGetResource> getAllUsers() {
        return userRepository.findAll()
                .stream().map(user->new UserGetResource(
                        user.getId(),
                        user.getEmail(),
                        user.getName()
                )).toList();
    }

    @Override
    public UserGetResource createUser(UserRegisterPostResource registerPost) {

        if(registerPost.getName()==null){
            throw new RequiredFieldException("Username is required");
        }
        if(registerPost.getPassword()==null){
            throw new RequiredFieldException("Password is required");
        }
        if(registerPost.getEmail()==null){
            throw new RequiredFieldException("Email is required");
        }
        var existedUser=userRepository.findByName(registerPost.getName());
        if(existedUser.isPresent()){
            throw new UserAlreadyExistsException("Username already exists try with different name : "+registerPost.getName());
        }
        log.info("Creating user {}",registerPost.getName());

        var user =new User();
        user.setPassword(registerPost.getPassword());
        user.setName(registerPost.getName());
        user.setEmail(registerPost.getEmail());
        userRepository.save(user);
        return new UserGetResource(
                user.getId(),
                user.getEmail(),
                user.getName()
        );

    }
}
