package com.yarch.booksinfoservice.reposiotries;

import com.yarch.booksinfoservice.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void itShouldReturnBookExist() {

        Book book = new Book("SN0001", "Test Book");
        bookRepository.save(book);

        Boolean result = bookRepository.isExistSNNumber(book.getId());

        assertThat(result).isTrue();
    }

    @Test
    void itShoutReturnBookIsNotExist(){

        String snNumber = "SB9991";

        Boolean result = bookRepository.isExistSNNumber(snNumber);

        assertThat(result).isFalse();
    }
}