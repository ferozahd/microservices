package com.microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("RESTAURANT", r -> r
						.path("/restaurant/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://RESTAURANT")
				)

				.route("PAYMENTS", r -> r
						.path("/payments/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("paymentsCB")
										.setFallbackUri("forward:/fallback/payments")))
						.uri("lb://PAYMENTS")
				)
				.route("SALE", r -> r
						.path("/sales/**")
						.filters(f -> f.stripPrefix(1)
								.circuitBreaker(c -> c.setName("salesCB")
								.setFallbackUri("forward:/fallback/sales")))
						.uri("lb://SALES")
				)

				.build();
	}
}
