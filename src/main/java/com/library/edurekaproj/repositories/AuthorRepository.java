package com.library.edurekaproj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.edurekaproj.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{


}