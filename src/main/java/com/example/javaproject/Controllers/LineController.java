package com.example.javaproject.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.javaproject.DTO.LineDto;
import com.example.javaproject.DTO.LineTime;
import com.example.javaproject.DTO.StationDto;
import com.example.javaproject.Models.Line;
import com.example.javaproject.Services.LineService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/Line")
public class LineController {

    @Autowired
    public LineService lineService;
    @GetMapping("/getStations/{id}")
    public ResponseEntity<List<StationDto>> getStations(@PathVariable Long id) {
        Optional<List<StationDto>> stations = lineService.getStations(id);
        if(stations.isPresent())
            return ResponseEntity.ok().body(stations.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getTravels/{id}")
    public ResponseEntity<List<LineTime>> getTravels(@PathVariable Long id) {
        Optional<List<LineTime>> lineTimes = lineService.getTravels(id);
        if(lineTimes.isPresent())
            return ResponseEntity.ok().body(lineTimes.get());
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/addStation/{id}/{stationId}/{index}")
    public ResponseEntity<Void> addStation(@PathVariable Long id, @PathVariable Long stationId, @PathVariable int index) {
        lineService.addStation(id,stationId, index);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/deleteStation/{id}/{stationId}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id, @PathVariable Long stationId) {
        lineService.deleteStation(id,stationId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("add")
    public ResponseEntity<Line> add(@RequestBody LineDto line) {
       Optional<Line> temp = lineService.add(line);
       if(temp.isPresent())
            return ResponseEntity.ok().body(temp.get()); 
        return ResponseEntity.badRequest().build();
    }
    
    
}
