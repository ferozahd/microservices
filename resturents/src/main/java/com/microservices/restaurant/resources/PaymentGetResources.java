package com.microservices.restaurant.resources;

import java.time.LocalDateTime;

public record PaymentGetResources(
        Long id,
        String userName,
        Long amount,
        LocalDateTime paymentAt,
        String shopName,
        String shopAddress
) {
}
