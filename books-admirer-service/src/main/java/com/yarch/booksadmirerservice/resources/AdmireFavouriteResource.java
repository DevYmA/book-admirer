package com.yarch.booksadmirerservice.resources;

import com.yarch.booksadmirerservice.model.AdmireFavourite;
import com.yarch.booksadmirerservice.model.Book;
import com.yarch.booksadmirerservice.model.UserRating;
import com.yarch.booksadmirerservice.services.InfoService;
import com.yarch.booksadmirerservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/favourite-book")
public class AdmireFavouriteResource {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private InfoService infoService;

    @GetMapping("/{userId}")
    public List<AdmireFavourite> getFavorites(@PathVariable("userId") String userId) {

        UserRating userRating = ratingService.getUserRatings(userId);

        List<AdmireFavourite> admireFavourites = userRating.getRatings().stream().map(rating -> {
            Book book = infoService.getBookInfo(rating.getBookId());
            return new AdmireFavourite("User ", book.getName(), rating.getRating());
        }).collect(Collectors.toList());
        return admireFavourites;
    }

}
