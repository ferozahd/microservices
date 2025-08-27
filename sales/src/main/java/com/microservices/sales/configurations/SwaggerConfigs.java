package com.microservices.sales.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfigs {
    @Bean
    public OpenAPI customOpenAPI() {
        var openAPI = new OpenAPI();
        openAPI.addServersItem(new Server()
                .url("/sales")  // Gateway path
                .description("Gateway URL for Restaurant Service"));
        return openAPI;
    }
}
