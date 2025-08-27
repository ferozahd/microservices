package com.microservices.sales.controllers;

import com.microservices.sales.resouces.SalesGetResources;
import com.microservices.sales.resouces.SalesPostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
public interface SalesController {

    @PostMapping("/create-sales")
    ResponseEntity<SalesGetResources> createSales(@RequestBody SalesPostResource salesPostResource);

    @GetMapping("/all-sales")
    ResponseEntity<List<SalesGetResources>> getAllSales();

    @GetMapping("/sales-by-name")
    ResponseEntity<List<SalesGetResources>> getSalesByUsername(@RequestParam String name);


}
