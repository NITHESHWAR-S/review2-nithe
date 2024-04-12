package com.nithe.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nithe.bookstore.model.Book;
import com.nithe.bookstore.repository.BookRepository;

import java.util.List;


@Service
public class UniversalService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooksSorted(String sortBy) {
        return bookRepository.findAll(Sort.by(sortBy));
    }

    public Page<Book> getAllBooksPaged(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        return bookRepository.findAll(pageRequest);
    }

}
