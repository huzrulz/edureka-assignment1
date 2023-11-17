package com.edureka.author.controllers;

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

import com.edureka.author.entity.Author;
import com.edureka.author.repository.AuthorRepository;

@RestController
@RequestMapping("/api")
public class AuthorController {
   

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/healthCheck")
	public String healthCheck() {
		return "up";
	}
    
    @GetMapping("/authors")
	public ResponseEntity<List<Author>> findAllAuthors() {
		
        List<Author> authors = authorRepository.findAll();
        return new ResponseEntity<>(authors,HttpStatus.OK);
	}


    @GetMapping("/author/{id}")
	public ResponseEntity<Author> findAuthorById(@PathVariable("id") Long id) {
	
        Optional<Author> authorData = authorRepository.findById(id);

		return new ResponseEntity<>(authorData.get(), HttpStatus.OK);
	}

    @PostMapping("/author/add")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        try {
            Author _author = authorRepository.save(new Author(author.getName(), author.getDescription()));
           return new ResponseEntity<>(_author, HttpStatus.CREATED);
          } catch (Exception e) {
            System.out.println("print"+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
         
	}

	@PutMapping("/author")
	public ResponseEntity<Author> update(@RequestBody Author author) {
        Optional<Author> authorData = authorRepository.findById(author.getId());

        Author author1 = authorData.get();
        author1.setName(author.getName());
        author1.setDescription(author.getDescription());
       
        return new ResponseEntity<>(authorRepository.save(author1), HttpStatus.OK);
	}

    @DeleteMapping("/author/{id}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
