package com.microservices.restaurant.resources;

import java.util.List;

public record OrderCompletionGetResources(
        long id,
        String name,
        String email,
        List<PaymentGetResources> payments,
        List<SalesGetResources> sales
) {

}
