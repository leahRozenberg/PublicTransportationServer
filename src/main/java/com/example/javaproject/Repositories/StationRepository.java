package com.example.javaproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaproject.Models.Station;

public interface StationRepository extends JpaRepository<Station, Long>{
    
}
