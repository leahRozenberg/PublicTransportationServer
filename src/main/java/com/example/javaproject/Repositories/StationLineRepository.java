package com.example.javaproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javaproject.Models.StationLine;
@Repository
public interface StationLineRepository extends JpaRepository<StationLine,Long>{
    
}
