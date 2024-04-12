package com.nithe.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nithe.bookstore.model.Book;
import com.nithe.bookstore.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r.book FROM Review r WHERE r.rating > :rating")
    List<Book> findBooksByRatingGreaterThan(@Param("rating") float rating);

}
