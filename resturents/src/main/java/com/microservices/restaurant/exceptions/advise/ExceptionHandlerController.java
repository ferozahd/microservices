package com.microservices.restaurant.exceptions.advise;

import com.microservices.restaurant.exceptions.FeignServiceFailedException;
import com.microservices.restaurant.exceptions.RequiredFieldException;
import com.microservices.restaurant.exceptions.UserAlreadyExistsException;
import com.microservices.restaurant.exceptions.UserNotFoundException;
import com.microservices.restaurant.resources.error.ErrorResources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler({FeignServiceFailedException.class})
    public ResponseEntity<ErrorResources> handleFeignClientException(RuntimeException exception){
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorResources(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),exception.getMessage())
                );
    }

    @ExceptionHandler({RequiredFieldException.class, UserAlreadyExistsException.class, UserNotFoundException.class})
    public ResponseEntity<ErrorResources> handleRequestFieldException(RuntimeException exception){
        log.warn(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorResources(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),exception.getMessage())
                );
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResources> uncheckedExceptionHandler(Exception exception){
        log.error("Internal server could not operate {}",exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorResources(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),exception.getMessage())
                );
    }

}
