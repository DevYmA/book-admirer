package com.yarch.booksadmirerservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yarch.booksadmirerservice.model.AdmireFavourite;
import com.yarch.booksadmirerservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Service
public class RatingService {

    @Autowired
    private WebClient.Builder webCliBuilder;

    @HystrixCommand(
            fallbackMethod = "getUserFallbackRatings",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            }
    )
    public UserRating getUserRatings(String userId){
        return webCliBuilder.build()
                .get()
                .uri("http://BOOK-RATING-SERVICE/api/v1/ratings/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();
    }

    public UserRating getUserFallbackRatings(String userId){
        return new UserRating("no-ratings", Arrays.asList());
    }
}
