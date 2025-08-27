package com.microservices.restaurant.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCompletionPostResources  implements SalesPostResource,PaymentPostResources{
    private String userName;
    private Long numberOfProducts;
    private String shopName;
    private String shopAddress;
    private Long amount;
}
