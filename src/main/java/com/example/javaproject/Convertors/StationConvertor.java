package com.example.javaproject.Convertors;

import java.util.ArrayList;
import java.util.List;

import com.example.javaproject.DTO.StationDto;
import com.example.javaproject.Models.Station;

public class StationConvertor {
    public StationDto ToDto(Station station) {
        StationDto dto = new StationDto();
        dto.setId(station.getId());
        dto.setName(station.getName());
        return dto;
    }

    public Station ToModel(StationDto station) {
        Station model = new Station();
        model.setId(station.getId());
        model.setName(station.getName());
        return model;
    }

    public List<StationDto> ToDto(List<Station> stations){
        List<StationDto> list = new ArrayList<StationDto>();
        for (Station station : stations) {
            list.add(ToDto(station));
        }
        return list;
    }

    public List<Station> ToModel(List<StationDto> stations){
        List<Station> list = new ArrayList<Station>();
        for (StationDto station : stations) {
            list.add(ToModel(station));
        }
        return list;
    }
}
