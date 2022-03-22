package com.yarch.booksadmirerservice.resources;

import com.yarch.booksadmirerservice.model.AdmireFavourite;
import com.yarch.booksadmirerservice.model.Book;
import com.yarch.booksadmirerservice.model.Rating;
import com.yarch.booksadmirerservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/favourite-book")
public class AdmireFavouriteResource {

    @Autowired
    private WebClient.Builder webCliBuilder;

    @GetMapping("/{userId}")
    public List<AdmireFavourite> getFavorites(@PathVariable("userId") String userId){

        UserRating userRating = webCliBuilder.build()
                .get()
                .uri("http://BOOK-RATING-SERVICE/api/v1/ratings/users/"+userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();

        List<AdmireFavourite> admireFavourites = userRating.getRatings().stream().map(rating -> {
            Book book = webCliBuilder.build()
                    .get()
                    .uri("http://BOOKS-INFO-SERVICE/api/v1/books/"+rating.getBookId())
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();

            return new AdmireFavourite("User ", book.getName(), rating.getRating());
        }).collect(Collectors.toList());
        return admireFavourites;
    }
}
