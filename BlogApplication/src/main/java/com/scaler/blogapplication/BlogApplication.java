package com.scaler.blogapplication;

import com.scaler.blogapplication.tokens.JWTTokenService;
import com.scaler.blogapplication.tokens.TokenService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }


    @Bean(BeanDefinition.SCOPE_SINGLETON)
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean(BeanDefinition.SCOPE_SINGLETON)
//    public TokenService tokenService(){
//        return new JWTTokenService();
//    }
}
