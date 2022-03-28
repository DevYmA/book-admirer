package com.yarch.booksinfoservice.services;

import com.yarch.booksinfoservice.exceptions.ElementNotFoundException;
import com.yarch.booksinfoservice.model.Book;
import com.yarch.booksinfoservice.reposiotries.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public void addBook(Book book) {

        Boolean existSNNumber = bookRepository.isExistSNNumber(book.getId());

        if(existSNNumber){
            throw new ElementNotFoundException("Book " + book.getId()+ "already exist");
        }
        bookRepository.save(book);
    }

}
