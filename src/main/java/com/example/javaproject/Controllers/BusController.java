package com.example.javaproject.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.javaproject.DTO.BusDto;
import com.example.javaproject.Models.Bus;
import com.example.javaproject.Services.BusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Bus")
public class BusController {
    @Autowired
    public BusService busService;

    @GetMapping("/getBySeats/{seats}")
    public ResponseEntity<List<BusDto>> getBySeats(@PathVariable int seats) {
        Optional<List<BusDto>> buses = busService.getBySeats(seats);
        if(buses.isPresent())
            return ResponseEntity.ok().body(buses.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Bus> add(@RequestBody BusDto bus) {
        Optional<Bus> bus2 = busService.add(bus);
        if(bus2.isPresent())
            return ResponseEntity.ok().body(bus2.get());
        return ResponseEntity.badRequest().build();
    }
    
}
