package com.microservices.restaurant.configurations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for development
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Allow all requests without auth
                )
                .httpBasic(AbstractHttpConfigurer::disable) // No HTTP Basic
                .formLogin(AbstractHttpConfigurer::disable); // No login page

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        // Return empty or custom logic — for now, no users
        return username -> null;
    }
}