package com.example.javaproject.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.javaproject.DTO.LineTime;
import com.example.javaproject.Services.StationService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/Station")
public class StationController {
    
    @Autowired
    public StationService stationService;
    @GetMapping("/getLine/{id}/{line}")
    public ResponseEntity<List<LineTime>> getLine(@PathVariable Long id, @PathVariable char line) {
        Optional<List<LineTime>> times = stationService.getLine(id,line);
        if(times.isPresent())
            return ResponseEntity.ok().body(times.get());
        return ResponseEntity.notFound().build();
    }
    
}
