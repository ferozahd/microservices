package com.microservices.payments.controllers.impl;

import com.microservices.payments.controllers.PaymentController;
import com.microservices.payments.resources.PaymentGetResources;
import com.microservices.payments.resources.PaymentPostResources;
import com.microservices.payments.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentControllerImpl implements PaymentController {
    private final PaymentService paymentService;

    @Override
    public ResponseEntity<PaymentGetResources> createPayment(PaymentPostResources paymentPostResources) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.createPayment(paymentPostResources));
    }

    @Override
    public ResponseEntity<List<PaymentGetResources>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @Override
    public ResponseEntity<List<PaymentGetResources>> getPaymentsByUsername(String username) {
        return ResponseEntity.ok(paymentService.getPaymentsByUserName(username));
    }
}
