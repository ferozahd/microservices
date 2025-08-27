package com.microservices.payments.controllers;

import com.microservices.payments.resources.PaymentGetResources;
import com.microservices.payments.resources.PaymentPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
public interface PaymentController {

    @PostMapping("/create-payment")
    ResponseEntity<PaymentGetResources> createPayment(@RequestBody PaymentPostResources paymentPostResources);

    @GetMapping("/all")
    ResponseEntity<List<PaymentGetResources>> getAllPayments();


    @GetMapping("/by-user")
    ResponseEntity<List<PaymentGetResources>> getPaymentsByUsername(@RequestParam String username);

}
