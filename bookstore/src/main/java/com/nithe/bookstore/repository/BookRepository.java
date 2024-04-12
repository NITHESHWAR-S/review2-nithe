package com.nithe.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nithe.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    
    @Query("SELECT b FROM Book b WHERE b.launchYear = :year")
    List<Book> findBooksByYear(@Param("year") String year);

}
