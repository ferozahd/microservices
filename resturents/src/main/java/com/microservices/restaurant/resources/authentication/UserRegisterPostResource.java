package com.microservices.restaurant.resources.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterPostResource {
    private String name;
    private String email ;
    private String password;
}
