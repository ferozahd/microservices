package com.microservices.sales.repositories;

import com.microservices.sales.entities.Sales;
import com.microservices.sales.resouces.SalesGetResources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findByUserName(String username);
}
