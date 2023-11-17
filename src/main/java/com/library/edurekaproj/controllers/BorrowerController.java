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

import com.library.edurekaproj.entity.Borrower;
import com.library.edurekaproj.repositories.BorrowerRepository;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
    @Autowired
    private BorrowerRepository borrowerRepository;

   

    @GetMapping()
    public ResponseEntity<List<Borrower>> GetAllBorrower(@RequestParam(required = false) String borrower) {
        return ResponseEntity.status(HttpStatus.OK).body(borrowerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrower> GetByid(@PathVariable Long id)
    {
        Optional<Borrower> retunBorrower = borrowerRepository.findById(id);
        if(retunBorrower != null)
            return ResponseEntity.ok(retunBorrower.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Borrower> SaveBorrower(Borrower borrower) {
        Borrower retunBorrower = borrowerRepository.save(borrower);
        return ResponseEntity.status(HttpStatus.CREATED).body(retunBorrower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrower> UpdateBorrower(@PathVariable Long id, Borrower borrower) throws Exception {
        Borrower borrower1 = borrowerRepository.findById(borrower.getId())
        .orElseThrow(() -> new Exception("Not found Tutorial with id = " + borrower.getId()));
         return new ResponseEntity<>(borrowerRepository.save(borrower1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteBorrower(@PathVariable Long id)
    {
        borrowerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
