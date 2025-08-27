package com.microservices.restaurant.resources;

public record SalesGetResources (
        long id,
        String userName,
        Long numberOfProducts,
        String shopName,
        String shopAddress
){

}
