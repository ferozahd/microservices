package com.microservices.sales.services;

import com.microservices.sales.resouces.SalesGetResources;
import com.microservices.sales.resouces.SalesPostResource;

import java.util.List;

public interface SalesService {
    SalesGetResources createSales(SalesPostResource salesPostResource);
    List<SalesGetResources> getAllSales( );
    List<SalesGetResources> getSalesByUserName(String username);
}
