package com.example.javaproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javaproject.Models.Travel;
@Repository
public interface TravelRepository extends JpaRepository<Travel, Long>{
    
}
