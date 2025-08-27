package com.microservices.payments.services.impl;

import com.microservices.payments.resources.PaymentGetResources;
import com.microservices.payments.entities.Payment;
import com.microservices.payments.exceptions.NegativeNumberFieldException;
import com.microservices.payments.exceptions.RequiredFieldException;
import com.microservices.payments.repositories.PaymentRepository;
import com.microservices.payments.resources.PaymentPostResources;
import com.microservices.payments.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public PaymentGetResources createPayment(PaymentPostResources paymentPostResources) {

        if(paymentPostResources.getUserName()==null){
            throw new RequiredFieldException("Username is required to create sales");
        }

        if(paymentPostResources.getShopAddress()==null){
            throw new RequiredFieldException("Shop address is required to create sales");

        }

        if(paymentPostResources.getShopName()==null){
            throw new RequiredFieldException("Shop name is required to create sales");

        }  if(paymentPostResources.getAmount()==null || paymentPostResources.getAmount()<=0){
            throw new NegativeNumberFieldException("Amount should be more than 0");

        }
        var payment = new Payment();
        payment.setPaymentAt(LocalDateTime.now());
        payment.setUserName(paymentPostResources.getUserName());
        payment.setAmount(paymentPostResources.getAmount());
        payment.setShopName(paymentPostResources.getShopName());
        payment.setShopAddress(paymentPostResources.getShopAddress());
        paymentRepository.save(payment);
        log.info("Payment has been created for user {}",payment.getUserName());
        return new PaymentGetResources(
                payment.getId(),
                payment.getUserName(),
                payment.getAmount(),
                payment.getPaymentAt(),
                payment.getShopName(),
                payment.getShopAddress()
        );
    }

    @Override
    public List<PaymentGetResources> getAllPayments() {
        log.info("get app payment");
        return paymentRepository.findAll().stream()
                .map(payment -> new PaymentGetResources(
                        payment.getId(),
                        payment.getUserName(),
                        payment.getAmount(),
                        payment.getPaymentAt(),
                        payment.getShopName(),
                        payment.getShopAddress()
                )).toList();
    }

    @Override
    public List<PaymentGetResources> getPaymentsByUserName(String username) {
        log.info("Get payment for user {}",username);
        return paymentRepository.findByUserName(username).stream()
                .map(payment -> new PaymentGetResources(
                        payment.getId(),
                        payment.getUserName(),
                        payment.getAmount(),
                        payment.getPaymentAt(),
                        payment.getShopName(),
                        payment.getShopAddress()
                )).toList();
    }
}
