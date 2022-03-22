package com.yarch.booksinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BooksInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksInfoServiceApplication.class, args);
    }

}
