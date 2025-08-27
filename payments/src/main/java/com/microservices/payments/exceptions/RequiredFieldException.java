package com.microservices.payments.exceptions;

public class RequiredFieldException extends RuntimeException {
    public RequiredFieldException(String message) {
        super(message);
    }
}
