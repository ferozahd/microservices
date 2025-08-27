package com.microservices.restaurant.exceptions;

public class FeignServiceFailedException extends RuntimeException {
    public FeignServiceFailedException(String message) {
        super(message);
    }
}
