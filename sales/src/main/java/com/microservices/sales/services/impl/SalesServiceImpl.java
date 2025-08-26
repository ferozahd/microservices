package com.microservices.sales.services.impl;

import com.microservices.sales.entities.Sales;
import com.microservices.sales.exceptions.NegativeNumberFieldException;
import com.microservices.sales.exceptions.RequiredFieldException;
import com.microservices.sales.repositories.SalesRepository;
import com.microservices.sales.resouces.SalesGetResources;
import com.microservices.sales.resouces.SalesPostResource;
import com.microservices.sales.services.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    @Override
    public SalesGetResources createSales(SalesPostResource salesPostResource) {

        if(salesPostResource.getUserName()==null){
            throw new RequiredFieldException("Username is required to create sales");
        }

        if(salesPostResource.getShopAddress()==null){
            throw new RequiredFieldException("Shop address is required to create sales");

        }

        if(salesPostResource.getShopName()==null){
            throw new RequiredFieldException("Shop name is required to create sales");

        }  if(salesPostResource.getNumberOfProducts()==null || salesPostResource.getNumberOfProducts()<=0){
            throw new NegativeNumberFieldException("Product quantities should be more than 0");

        }

        var sales =new Sales();
        sales.setShopAddress(salesPostResource.getShopAddress());
        sales.setUserName(salesPostResource.getUserName());
        sales.setNumberOfProducts(salesPostResource.getNumberOfProducts());
        sales.setShopName(salesPostResource.getShopName());
        log.info("creating sales for user {}", sales.getUserName());
        salesRepository.save(sales);

        return new SalesGetResources(sales.getId(),
                sales.getUserName(),
                sales.getNumberOfProducts(),
                sales.getShopName(),
                sales.getShopAddress());
    }

    @Override
    public List<SalesGetResources> getAllSales() {
        log.info("Getting all sales ");
        return salesRepository.findAll()
                .stream().map( sales->new SalesGetResources(sales.getId(),
                        sales.getUserName(),
                        sales.getNumberOfProducts(),
                        sales.getShopName(),
                        sales.getShopAddress())).toList();
    }

    @Override
    public List<SalesGetResources> getSalesByUserName(String username) {
        log.info("Getting all sales by username : {}",username);
        return salesRepository.findByUserName(username)
                .stream().map(sales-> new SalesGetResources(sales.getId(),
                        sales.getUserName(),
                        sales.getNumberOfProducts(),
                        sales.getShopName(),
                        sales.getShopAddress()))
                .toList();

    }
}
