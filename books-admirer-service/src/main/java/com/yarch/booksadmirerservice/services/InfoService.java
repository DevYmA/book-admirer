package com.yarch.booksadmirerservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yarch.booksadmirerservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class InfoService {

    @Autowired
    private WebClient.Builder webCliBuilder;

    @HystrixCommand(
            fallbackMethod = "getFallbackBookInfo",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            }
    )
    public Book getBookInfo(String bookId){
        return  webCliBuilder.build()
                .get()
                .uri("http://BOOKS-INFO-SERVICE/api/v1/books/" + bookId)
                .retrieve()
                .bodyToMono(Book.class)
                .block();
    }

    public Book getFallbackBookInfo(String bookId){
        return new Book("no-id", "no desc");
    }

}
