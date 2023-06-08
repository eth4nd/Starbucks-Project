package com.example.springstarbucksapi.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;


@Configuration
public class WebConfig {
    @Bean
    public Queue cashier() {
        return new Queue("cashier");
    }
}


