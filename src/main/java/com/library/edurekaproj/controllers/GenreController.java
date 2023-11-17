package com.library.edurekaproj.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.edurekaproj.entity.Genre;
import com.library.edurekaproj.repositories.GenreRepository;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    
    @GetMapping()
    public ResponseEntity<List<Genre>> GetAllAuthor() {
        return ResponseEntity.status(HttpStatus.OK).body(genreRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> GetByid(@PathVariable Long id)
    {
        Optional<Genre> retunGenre = genreRepository.findById(id);
        if(retunGenre != null)
            return new ResponseEntity<>(retunGenre.get(), HttpStatus.OK);
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Genre> SaveGenre(Genre genre) {
        Genre retunGenre = genreRepository.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(retunGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> UpdateGenre(@PathVariable Long id, Genre genre) throws Exception {
       
        Genre retunGenre = genreRepository.findById(genre.getId())
       .orElseThrow(() -> new Exception("Not found Tutorial with id = " + genre.getId()));
        return new ResponseEntity<>(genreRepository.save(retunGenre), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteGenre(@PathVariable Long id)
    {
        genreRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
