package com.nithe.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nithe.bookstore.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    
}
