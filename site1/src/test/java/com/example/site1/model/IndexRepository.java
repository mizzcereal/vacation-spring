package com.example.site1.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRespository extends JpaRepository<IndexEntity, Integer>{

    }
    

