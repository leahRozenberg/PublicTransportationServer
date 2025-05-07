package com.example.javaproject.Services;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.javaproject.DTO.LineTime;
import com.example.javaproject.Models.StationLine;
import com.example.javaproject.Models.Travel;
import com.example.javaproject.Repositories.StationLineRepository;
import com.example.javaproject.Repositories.TravelRepository;

@Service
public class StationService {
    @Autowired
    public TravelRepository travelRepository;
    @Autowired
    public StationLineRepository stationLineRepository;
    public Optional<List<LineTime>> getLine(Long id, char line){
        List<LineTime> times = new ArrayList<LineTime>();
        StationLine stationLine = new StationLine();
        stationLine.setStation_id(id);
        if(Character.isDigit(line))
            stationLine.setLine_id(Long.parseLong(line+""));
        List<StationLine> stationLines = stationLineRepository.findAll(Example.of(stationLine));
        for (StationLine temp : stationLines) {  
            List<Travel> travels = travelRepository.findAll().stream()
            .filter(t -> t.getLine().getId()== temp.getLine_id()).toList();
            for (Travel travel : travels) {
                if(LocalTime.now().plusMinutes(15)
                .isAfter(travel.getDepartureTime().toLocalTime()) && 
                LocalTime.now().isBefore(travel.getDepartureTime().toLocalTime().plusMinutes(temp.getStationOrder()))){
                LineTime lineTime = new LineTime();
                lineTime.Line_id = temp.getLine_id();
                lineTime.Station_id = id;
                lineTime.AraraiveTime = travel.getDepartureTime().toLocalTime()
                .plusMinutes(temp.getStationOrder());
                times.add(lineTime);
                }
            }
        }
        if(times.size()>0)
            return Optional.of(times);
        return Optional.empty();
    }
}
