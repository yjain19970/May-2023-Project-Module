package com.scaler.blogapplication.security;

import com.scaler.blogapplication.security.jwt.JWTAuthenticationFilter;
import com.scaler.blogapplication.tokens.TokenService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final TokenService tokenService;

    public SecurityConfig(@Qualifier("jWTTokenService") TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/articles").permitAll()
                .requestMatchers(HttpMethod.POST, "/users/login", "/users/signup").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();
        http.headers().frameOptions().disable();
        http.addFilterBefore(new JWTAuthenticationFilter(tokenService), AnonymousAuthenticationFilter.class);
        return http.build();
    }
}
