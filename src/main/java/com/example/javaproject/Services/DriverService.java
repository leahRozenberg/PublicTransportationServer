package com.example.javaproject.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaproject.Convertors.DriverConvertor;
import com.example.javaproject.DTO.DriverDto;
import com.example.javaproject.Models.Driver;
import com.example.javaproject.Repositories.DriverRepository;

@Service
public class DriverService {
    @Autowired
    public DriverRepository driverRepository;
    @Autowired
    public DriverConvertor driverConvertor;

    public Optional<Driver> add(DriverDto driver){
        try {
            Driver temp = driverRepository.save(driverConvertor.ToModel(driver));
            return Optional.of(temp);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
