package com.microservices.restaurant.services;

import com.microservices.restaurant.resources.OrderCompletionGetResources;
import com.microservices.restaurant.resources.OrderCompletionPostResources;

public interface OrderCompletionService {
    OrderCompletionGetResources completeOrder(OrderCompletionPostResources post);

    OrderCompletionGetResources getOrderByUserName(String username);
}
