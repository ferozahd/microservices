package com.microservices.sales.controllers.impl;

import com.microservices.sales.controllers.SalesController;
import com.microservices.sales.resouces.SalesGetResources;
import com.microservices.sales.resouces.SalesPostResource;
import com.microservices.sales.services.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SalesControllerImpl implements SalesController {
    private final SalesService salesService;


    @Override
    public ResponseEntity<SalesGetResources> createSales(SalesPostResource salesPostResource) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(salesService.createSales(salesPostResource));
    }

    @Override
    public ResponseEntity<List<SalesGetResources>> getAllSales() {
        return ResponseEntity.ok(salesService.getAllSales());
    }

    @Override
    public ResponseEntity<List<SalesGetResources>> getSalesByUsername(String name) {
        return ResponseEntity.ok(salesService.getSalesByUserName(name));
    }


}
