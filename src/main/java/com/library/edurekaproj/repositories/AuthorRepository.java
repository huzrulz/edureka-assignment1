package com.library.edurekaproj.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.jpa.boot.spring.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{


}