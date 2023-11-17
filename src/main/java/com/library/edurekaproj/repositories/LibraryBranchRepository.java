package com.library.edurekaproj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.edurekaproj.entity.LibraryBranch;

public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long>{
    
}
