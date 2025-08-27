package com.microservices.restaurant.controllers.impl;

import com.microservices.restaurant.controllers.OrderCompletionController;
import com.microservices.restaurant.resources.OrderCompletionGetResources;
import com.microservices.restaurant.resources.OrderCompletionPostResources;
import com.microservices.restaurant.services.OrderCompletionService;
import com.microservices.restaurant.services.impl.OrderCompletionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderCompletionControllerImpl implements OrderCompletionController {
    private final OrderCompletionService orderCompletionService;


    @Override
    public ResponseEntity<OrderCompletionGetResources> completeOrder(OrderCompletionPostResources post) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderCompletionService.completeOrder(post) );
    }


    @Override
    public ResponseEntity<OrderCompletionGetResources> getOrderByUserName(String username) {
        return ResponseEntity.ok(orderCompletionService.getOrderByUserName(username) );
    }
}
