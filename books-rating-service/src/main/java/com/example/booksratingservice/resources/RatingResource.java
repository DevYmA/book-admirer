package com.example.booksratingservice.resources;

import com.example.booksratingservice.model.Rating;
import com.example.booksratingservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingResource {

    @GetMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId){
        return  new Rating("SN00058",4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUsersRating(@PathVariable("userId") String userId){
        return  new UserRating(
                userId,
                Arrays.asList(
                        new Rating("SN0002", 6),
                        new Rating("SN2502", 4)
                )
        );
    }
}
