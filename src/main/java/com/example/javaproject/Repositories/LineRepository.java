package com.example.javaproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javaproject.Models.Line;

@Repository
public interface LineRepository extends JpaRepository<Line, Long>{

    
} 
