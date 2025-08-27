package com.microservices.restaurant.services.feignclients;

import com.microservices.restaurant.resources.PaymentGetResources;
import com.microservices.restaurant.resources.PaymentPostResources;
import com.microservices.restaurant.resources.SalesGetResources;
import com.microservices.restaurant.resources.SalesPostResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-feign-service",
        url = "${payment.service.url}"
)
public interface PaymentsFeignClient {

    @PostMapping("/create-payment")
    ResponseEntity<PaymentGetResources> createPayment(@RequestBody PaymentPostResources paymentPostResources);

}
