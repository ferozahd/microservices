package com.microservices.payments.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentPostResources {
    private String userName;
    private Long amount;
    private String shopName;
    private String shopAddress;
}
