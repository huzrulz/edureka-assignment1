package com.edureka.author.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edureka.author.entity.Author;
import com.edureka.author.repository.AuthorRepository;

public class AuthorService {
    private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)

	public Optional<Author> findAuthorById(Long id) {
		return authorRepository.findById(id);
	}

	
	public void createAuthor(Author author) {
		authorRepository.save(author);
	}

	
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}

	
	public void deleteAuthor(Long id) {
		//final Optional<Author> author = authorRepository.findById(id);

		authorRepository.deleteById(id);
	}
}
