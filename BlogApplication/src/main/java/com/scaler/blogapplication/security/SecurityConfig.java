package com.scaler.blogapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/articles").permitAll()
                .requestMatchers(HttpMethod.GET, "/users/login", "/users/signup")
                .permitAll()
                .anyRequest().permitAll();
        return http.build();
    }
}

/**
 *
 *
 *
 *
 * ----|filters|--|route|---> Controller
 */
