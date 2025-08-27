package com.microservices.restaurant.services.impl;

import com.microservices.restaurant.exceptions.FeignServiceFailedException;
import com.microservices.restaurant.exceptions.UserNotFoundException;
import com.microservices.restaurant.repositories.UserRepository;
import com.microservices.restaurant.resources.OrderCompletionGetResources;
import com.microservices.restaurant.resources.OrderCompletionPostResources;
import com.microservices.restaurant.services.OrderCompletionService;
import com.microservices.restaurant.services.feignclients.PaymentsFeignClient;
import com.microservices.restaurant.services.feignclients.SalesFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCompletionServiceImpl implements OrderCompletionService {

    private final SalesFeignClient salesFeignClient;
    private final PaymentsFeignClient paymentsFeignClient;
    private final UserRepository userRepository;

    private static final HttpStatusCode CREATED= HttpStatusCode.valueOf(HttpStatus.CREATED.value());
    private static final HttpStatusCode OK= HttpStatusCode.valueOf(HttpStatus.OK.value());

    @Override
    public OrderCompletionGetResources completeOrder(OrderCompletionPostResources post) {
        log.info("Creating a complete order for user {}",post.getUserName());
        var user= userRepository.findByName(post.getUserName())
                .orElseThrow(()->new UserNotFoundException("User not found for user :"+post.getUserName()));
        var sales = salesFeignClient.createSales(post);
        var payments = paymentsFeignClient.createPayment(post);

        if(!CREATED.equals(sales.getStatusCode())){
            throw new FeignServiceFailedException("Sales server not responding");
        }


        if(!CREATED.equals(payments.getStatusCode())){
            throw new FeignServiceFailedException("Payment server not responding");
        }


        return new OrderCompletionGetResources(
                user.getId(),
                user.getName(),
                user.getEmail(),
                Collections.singletonList(payments.getBody()),
                Collections.singletonList( sales.getBody())
        );
    }

    @Override
    public OrderCompletionGetResources getOrderByUserName(String username) {
        log.info("Find a complete order for user {}",username);
        var user= userRepository.findByName(username)
                .orElseThrow(()->new UserNotFoundException("User not found for user :"+username));
        var sales = salesFeignClient.getSalesByUsername(username);
        var payments = paymentsFeignClient.getPaymentsByUsername(username);

        if(!OK.equals(sales.getStatusCode())){
            throw new FeignServiceFailedException("Sales server not responding");
        }


        if(!OK.equals(payments.getStatusCode())){
            throw new FeignServiceFailedException("Payment server not responding");
        }


        return new OrderCompletionGetResources(
                user.getId(),
                user.getName(),
                user.getEmail(),
                payments.getBody(),
                sales.getBody()
        );
    }
}
