package com.example.javaproject.Controllers;

import org.springframework.web.bind.annotation.*;

import com.example.javaproject.DTO.TravelDto;
import com.example.javaproject.Services.TravelService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/Travel")
public class TravelController {
    @Autowired
    public TravelService travelService;
    @PostMapping("/add")
    public ResponseEntity<Void> addTravelEntity(@RequestBody TravelDto entity) {
        if(travelService.createTravel(entity))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getById/{Id}")
    public ResponseEntity<TravelDto> getTravelEntity(@PathVariable Long id) {
        Optional<TravelDto> travel = travelService.getById(id);
        if(travel.isPresent())
            return ResponseEntity.ok().body(travel.get());
        return ResponseEntity.notFound().build();
    }
    
    
}
