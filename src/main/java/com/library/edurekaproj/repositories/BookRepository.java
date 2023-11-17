package com.library.edurekaproj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.edurekaproj.entity.Book;

public interface  BookRepository  extends JpaRepository<Book, Long>{
    
}
