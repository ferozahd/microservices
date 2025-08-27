package com.microservices.restaurant.controllers;

import com.microservices.restaurant.resources.OrderCompletionGetResources;
import com.microservices.restaurant.resources.OrderCompletionPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("authentication")
public interface OrderCompletionController {

    @PostMapping("/order-creation")
    ResponseEntity<OrderCompletionGetResources> completeOrder(@RequestBody OrderCompletionPostResources post);

    @GetMapping("/order-by-user")
    ResponseEntity<OrderCompletionGetResources> getOrderByUserName(@RequestParam String username);
}
