package com.yarch.booksinfoservice.reposiotries;


import com.yarch.booksinfoservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(""+
            "SELECT CASE WHEN COUNT(book) > 0 THEN TRUE ELSE FALSE END FROM  Book book WHERE book.id = ?1 "
    )
    Boolean isExistSNNumber(String SNNumber);
}
