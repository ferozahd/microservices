package com.microservices.payments.exceptions;

import com.microservices.payments.resources.errors.ErrorResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({NegativeNumberFieldException.class, RequiredFieldException.class})
    public ResponseEntity<ErrorResources> handleRequestFieldException(RuntimeException exception){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorResources(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),exception.getMessage())
                );
    }
}
