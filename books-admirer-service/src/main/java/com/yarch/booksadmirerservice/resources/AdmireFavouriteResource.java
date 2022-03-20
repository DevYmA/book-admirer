package com.yarch.booksadmirerservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/favourite-book")
public class AdmireFavouriteResource {

    @GetMapping("/{userId}")
    public List<AdmireFavourite> getFavorites(@PathVariable("userId") String userId){
        return Collections.singletonList(
                new AdmireFavourite("Harry Potter", "Desc", 2)
        );
    }
}
