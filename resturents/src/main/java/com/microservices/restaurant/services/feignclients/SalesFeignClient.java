package com.microservices.restaurant.services.feignclients;

import com.microservices.restaurant.resources.SalesGetResources;
import com.microservices.restaurant.resources.SalesPostResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "sales-service",
        url = "${sales.service.url}"
)
public interface SalesFeignClient {

    @PostMapping("/create-sales")
    ResponseEntity<SalesGetResources> createSales(@RequestBody SalesPostResource salesPostResource);

}
