package com.microservices.payments.exceptions;

public class NegativeNumberFieldException extends RuntimeException {
    public NegativeNumberFieldException(String message) {
        super(message);
    }
}
