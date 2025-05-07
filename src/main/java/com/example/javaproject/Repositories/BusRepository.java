package com.example.javaproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.javaproject.Models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long>{
} 
