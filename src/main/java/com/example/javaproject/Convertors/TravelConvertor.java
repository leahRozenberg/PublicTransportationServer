package com.example.javaproject.Convertors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.javaproject.DTO.TravelDto;
import com.example.javaproject.Models.Travel;


public class TravelConvertor {

    @Autowired
    public BusConvertor busConvertor;
    @Autowired
    public DriverConvertor driverConvertor;
    @Autowired
    public LineConvertor lineConvertor;
    public TravelDto ToDto(Travel travel) {
        TravelDto dto = new TravelDto();
        dto.setBus(busConvertor.ToDto(travel.getBus()));
        dto.setDriver(driverConvertor.ToDto(travel.getDriver()));
        dto.setLine(lineConvertor.ToDto(travel.getLine()));
        dto.setDepartureTime(travel.getDepartureTime());
        return dto;
    }

    public Travel ToModel(TravelDto travel) {
        Travel model = new Travel();
        model.setId(travel.getId());
        model.setBus(busConvertor.ToModel(travel.getBus()));
        model.setDriver(driverConvertor.ToModel(travel.getDriver()));
        model.setLine(lineConvertor.ToModel(travel.getLine()));
        travel.setDepartureTime(travel.getDepartureTime());
        return model;
    }

    public List<TravelDto> ToDto(List<Travel> travels){
        List<TravelDto> list = new ArrayList<TravelDto>();
        for (Travel travel : travels) {
            list.add(ToDto(travel));
        }
        return list;
    }

    public List<Travel> ToModel(List<TravelDto> travels){
        List<Travel> list = new ArrayList<Travel>();
        for (TravelDto travel : travels) {
            list.add(ToModel(travel));
        }
        return list;
    }
}
