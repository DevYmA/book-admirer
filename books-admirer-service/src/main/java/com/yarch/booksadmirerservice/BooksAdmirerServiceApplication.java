package com.yarch.booksadmirerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class BooksAdmirerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksAdmirerServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebCliBuilder(){
        return WebClient.builder();
    }

}
