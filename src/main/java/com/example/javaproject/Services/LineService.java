package com.example.javaproject.Services;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaproject.Convertors.LineConvertor;
import com.example.javaproject.Convertors.StationConvertor;
import com.example.javaproject.DTO.LineDto;
import com.example.javaproject.DTO.LineTime;
import com.example.javaproject.DTO.StationDto;
import com.example.javaproject.Models.StationLine;
import com.example.javaproject.Models.Travel;
import com.example.javaproject.Models.Line;
import com.example.javaproject.Models.Station;
import com.example.javaproject.Repositories.LineRepository;
import com.example.javaproject.Repositories.StationLineRepository;
import com.example.javaproject.Repositories.StationRepository;
import com.example.javaproject.Repositories.TravelRepository;

@Service
public class LineService {
    @Autowired
    public LineRepository lineRepository;
    @Autowired
    public StationRepository stationRepository;
    @Autowired
    public StationConvertor stationConvertor;
    @Autowired
    public TravelRepository travelRepository;
    @Autowired
    public StationLineRepository stationLineRepository;
    @Autowired
    public LineConvertor lineConvertor;
    public Optional<List<StationDto>> getStations(Long id){
        Optional<Line> line = lineRepository.findById(id);
        if(line.isPresent()){
            List<Station> stations = new ArrayList<Station>();
            line.get().getStationLines().stream().sorted((a,b)-> a.getStationOrder()-b.getStationOrder()).forEach(sl->stations.add(stationRepository.findById(sl.getStation_id()).get()));
            return Optional.of(stationConvertor.ToDto(stations));
        }
        return Optional.empty();
    }

    public void addStation(Long id, Long stationId, int index){
        StationLine stationLine = new StationLine();
        stationLine.setLine_id(id);
        stationLine.setStation_id(stationId);
        stationLine.setStationOrder(index);
        List<StationLine> stationLines = lineRepository.findById(id).get().getStationLines();
        stationLines.sort((a,b)-> a.getStationOrder()-b.getStationOrder());
        for (StationLine temp : stationLines) {
            if(temp.getStationOrder()>index)
                temp.setStationOrder(temp.getStationOrder()+1);
        }
        stationLines.add(stationLine);
        lineRepository.findById(id).get().setStationLines(stationLines);
    }

    public void deleteStation(Long id, Long stationId){
        List<StationLine> stationLines = lineRepository.findById(id).get().getStationLines();
        StationLine stationLine = stationLines.stream().filter(sl -> sl.getStation_id() == stationId).findFirst().get();
        stationLines.remove(stationLine);
        stationLines.sort((a,b)-> a.getStationOrder()-b.getStationOrder());
        for (StationLine temp : stationLines) {
            if(temp.getStationOrder()>stationLine.getStationOrder())
                temp.setStationOrder(temp.getStationOrder()-1);
        }

        lineRepository.findById(id).get().setStationLines(stationLines);
    }

    public Optional<List<LineTime>> getTravels(Long id){
        List<StationLine> stationLines = stationLineRepository.findAll().stream()
        .filter(sl -> sl.getLine_id() == id).toList();
        List<Travel> travels = travelRepository.findAll().stream()
        .filter(t -> t.getLine().getId() == id && LocalTime.now().
        isAfter(t.getDepartureTime().toLocalTime())).toList();
        List<LineTime> times = new ArrayList<>();
        for (Travel travel : travels) {
            Long min = Duration.between(LocalTime.now(), travel.getDepartureTime().toLocalTime()).toMinutes();
            Optional<StationLine> stationLine = stationLines.stream()
            .filter(sl -> sl.getStationOrder() == min).findFirst();
            if(stationLine.isPresent()){
                LineTime lineTime = new LineTime();
                lineTime.Line_id = id;
                lineTime.Station_id = stationLine.get().getStation_id();
                lineTime.AraraiveTime = LocalTime.now();
                times.add(lineTime);
            }
        }
        if(times.size() > 0)
            return Optional.of(times);
        return Optional.empty();
    }

    public Optional<Line> add(LineDto line){
        try {
            Line temp = lineRepository.save(lineConvertor.ToModel(line));
            return Optional.of(temp);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
