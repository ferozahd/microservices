package com.microservices.sales.resouces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesPostResource {
    private String userName;
    private Long numberOfProducts;
    private String shopName;
    private String shopAddress;
}
