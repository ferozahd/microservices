package com.microservices.sales.resouces;

public record SalesGetResources (
      long id,
      String userName,
      Long numberOfProducts,
      String shopName,
      String shopAddress
){

}
