package com.microservices.payments.services;

import com.microservices.payments.resources.PaymentGetResources;
import com.microservices.payments.resources.PaymentPostResources;

import java.util.List;

public interface PaymentService {
    PaymentGetResources createPayment(PaymentPostResources paymentPostResources);

    List<PaymentGetResources> getAllPayments();

    List<PaymentGetResources> getPaymentsByUserName(String username);
}
