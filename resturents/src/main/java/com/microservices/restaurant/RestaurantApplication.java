package com.microservices.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class RestaurantApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(RestaurantApplication.class, args);
		log.info("########################################################################");
		log.info("hello test for loki from restaruant application");
		log.info("hello test for loki from restaruant application");

		log.info("########################################################################");

	}

}
