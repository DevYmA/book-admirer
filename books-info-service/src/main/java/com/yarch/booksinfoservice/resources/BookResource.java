package com.yarch.booksinfoservice.resources;

import com.yarch.booksinfoservice.model.Book;
import com.yarch.booksinfoservice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId){

        return new Book("SN00254", "Harry Potter");
    }


}
