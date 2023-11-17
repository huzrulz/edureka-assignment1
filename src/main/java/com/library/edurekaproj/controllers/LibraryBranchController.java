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

import com.library.edurekaproj.entity.LibraryBranch;
import com.library.edurekaproj.repositories.LibraryBranchRepository;

@RestController
@RequestMapping("/api/library-branches")
public class LibraryBranchController {
   
    @Autowired
    LibraryBranchRepository librarybranchRepository;
   

    @GetMapping()
    public ResponseEntity<List<LibraryBranch>> GetAllLibrary() {
        return ResponseEntity.status(HttpStatus.OK).body(librarybranchRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBranch> GetByid(@PathVariable Long id)
    {
        Optional<LibraryBranch> retunLibrary = librarybranchRepository.findById(id);
        if(retunLibrary != null)
            return  new ResponseEntity<>(retunLibrary.get(), HttpStatus.OK);
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<LibraryBranch> SaveLibrary(LibraryBranch library) {
        LibraryBranch retunLibrary = librarybranchRepository.save(library);
        return new ResponseEntity<>(retunLibrary, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryBranch> UpdateLibrary(LibraryBranch library) throws Exception {
      
       LibraryBranch retunLibrary = librarybranchRepository.findById(library.getId())
       .orElseThrow(() -> new Exception("Not found Tutorial with id = " + library.getId()));
        return new ResponseEntity<>(librarybranchRepository.save(retunLibrary), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteLibrary(@PathVariable Long id)
    {
        librarybranchRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
