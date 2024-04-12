package com.nithe.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nithe.bookstore.model.Book;
import com.nithe.bookstore.services.UniversalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversalController {

    @Autowired
    private UniversalService universalService;


    //pagination and sorting
    @GetMapping("/books")
    public ResponseEntity<Page<Book>> getBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "bookId") String sortBy) {

        Page<Book> bookPage = universalService.getAllBooksPaged(page, size, sortBy);

        return ResponseEntity.ok(bookPage);
    }

    @GetMapping("/sortedBooks")
    public ResponseEntity<List<Book>> getSortedBooks(@RequestParam String sortBy) {
        List<Book> sortedBooks = universalService.getAllBooksSorted(sortBy);
        return ResponseEntity.ok(sortedBooks);
    }
}
