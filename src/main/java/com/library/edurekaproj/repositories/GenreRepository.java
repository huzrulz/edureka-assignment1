package com.library.edurekaproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.edurekaproj.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    
}
