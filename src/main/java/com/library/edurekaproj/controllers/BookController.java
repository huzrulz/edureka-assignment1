package com.library.edurekaproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.edurekaproj.repositories.BookRepository;
import com.library.edurekaproj.entity.Book;

@Controller
public class BookController {
    private final BookRepository bookRepository;


    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    @GetMapping("/api/books")
    public String getBooksList(Book book) {
        return "add-user";
    }

    @GetMapping("/api/books/{id}")
    public String getBook(Book book) {
        return "add-user";
    }

    @PostMapping("/api/books")
    public String addBook(Book book) {
        return "add-user";
    }

    @PutMapping("/api/books/{id}")
    public String updateBook(Book book) {
        return "add-user";
    }

    @DeleteMapping("/api/books/{id}")
    public String deleteBook(Book book) {
        return "add-user";
    }
    
  
    // additional CRUD methods
};