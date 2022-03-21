package com.yarch.booksadmirerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BooksAdmirerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksAdmirerServiceApplication.class, args);
    }

    @Bean
    public WebClient.Builder getWebCliBuilder(){
        return WebClient.builder();
    }

}
