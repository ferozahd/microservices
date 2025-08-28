package com.microservices.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/payments")
    public ResponseEntity<String> paymentsFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Payments service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/sales")
    public ResponseEntity<String> salesFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Sales service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/restaurants")
    public ResponseEntity<String> restaurantsFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Restaurants service is currently unavailable. Please try again later.");
    }


}
