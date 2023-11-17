package com.edureka.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edureka.author.entity.Author;



public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
