package com.yarch.booksinfoservice.services;

import com.yarch.booksinfoservice.exceptions.ElementNotFoundException;
import com.yarch.booksinfoservice.model.Book;
import com.yarch.booksinfoservice.reposiotries.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository);
    }

    @Test
    void getAllBooks() {
        bookService.getAllBooks();
        verify(bookRepository).findAll();
    }

    @Test
    void addBook() {
        Book book = new Book("SN0001", "Test Book");

        bookService.addBook(book);

        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book captorBook = bookArgumentCaptor.getValue();
        assertThat(captorBook).isEqualTo(book);
    }

    @Test
    void itShouldThrowBookExistExceptionWhenBookExist() {
        Book book = new Book("SN0001", "Test Book");

        given(bookRepository.isExistSNNumber(anyString())).willReturn(true);

        assertThatThrownBy(() -> bookService.addBook(book))
                .isInstanceOf(ElementNotFoundException.class)
                .hasMessage("Book " + book.getId() + "already exist");

        verify(bookRepository, never()).save(any());
    }


}