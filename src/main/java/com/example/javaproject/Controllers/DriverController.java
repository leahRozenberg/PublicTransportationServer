package com.example.javaproject.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.javaproject.DTO.DriverDto;
import com.example.javaproject.Models.Driver;
import com.example.javaproject.Services.DriverService;

@RestController
@RequestMapping("/Driver")
public class DriverController {
    @Autowired
    public DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<Driver> add(@RequestBody DriverDto driver) {
        Optional<Driver> temp = driverService.add(driver);
        if(temp.isPresent())
            return ResponseEntity.ok().body(temp.get());
        return ResponseEntity.badRequest().build();
    }
}
