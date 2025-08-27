package com.microservices.restaurant.resources;

public record UserGetResource(
        long id,
        String email,
        String name
) {
}
