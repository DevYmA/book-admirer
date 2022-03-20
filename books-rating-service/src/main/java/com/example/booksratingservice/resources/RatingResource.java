package com.example.booksratingservice.resources;

import com.example.booksratingservice.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingResource {

    @GetMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId){
        return  new Rating("SN00058",4);
    }
}
