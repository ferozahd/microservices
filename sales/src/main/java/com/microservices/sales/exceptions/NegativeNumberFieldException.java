package com.microservices.sales.exceptions;

public class NegativeNumberFieldException extends RuntimeException {
    public NegativeNumberFieldException(String message) {
        super(message);
    }
}
