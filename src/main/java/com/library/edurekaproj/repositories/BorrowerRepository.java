package com.library.edurekaproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.edurekaproj.entity.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower ,Long>{
    
}
