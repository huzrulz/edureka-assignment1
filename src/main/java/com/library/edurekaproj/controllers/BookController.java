package com.library.edurekaproj.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import com.library.edurekaproj.entity.Book;
import com.library.edurekaproj.repositories.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {
   

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/healthCheck")
	public String healthCheck() {
		return "up";
	}
    
    @GetMapping("/books")
	public ResponseEntity<List<Book>> findAllBooks() {
		
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books,HttpStatus.OK);
	}


    @GetMapping("/book/{id}")
	public ResponseEntity<Book> findBookById(@PathVariable("id") Long id) {
	
        Optional<Book> bookData = bookRepository.findById(id);

		return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
	}

    @PostMapping("/book/add")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book _book = bookRepository.save(new Book(book.getTitle(), book.getISBN(), book.getAuthorId()));
           return new ResponseEntity<>(_book, HttpStatus.CREATED);
          } catch (Exception e) {
            System.out.println("print"+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
         
	}

	@PutMapping("/book")
	public ResponseEntity<Book> update(@RequestBody Book book) {
        Optional<Book> bookData = bookRepository.findById(book.getId());

        Book book1 = bookData.get();
        return new ResponseEntity<>(bookRepository.save(book1), HttpStatus.OK);
	}

    @DeleteMapping("/book/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}