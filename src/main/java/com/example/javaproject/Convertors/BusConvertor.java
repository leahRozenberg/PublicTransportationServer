package com.example.javaproject.Convertors;

import java.util.ArrayList;
import java.util.List;

import com.example.javaproject.DTO.BusDto;
import com.example.javaproject.Models.Bus;

public class BusConvertor {
    public BusDto ToDto(Bus bus) {
        BusDto dto = new BusDto();
        dto.setId(bus.getId());
        dto.setLicense_plate(bus.getLicense_plate());
        dto.setSeats(bus.getSeats());
        return dto;
    }

    public Bus ToModel(BusDto bus) {
        Bus model = new Bus();
        model.setId(bus.getId());
        model.setLicense_plate(bus.getLicense_plate());
        model.setSeats(bus.getSeats());
        return model;
    }

    public List<BusDto> ToDto(List<Bus> buses){
        List<BusDto> list = new ArrayList<BusDto>();
        for (Bus bus : buses) {
            list.add(ToDto(bus));
        }
        return list;
    }

    public List<Bus> ToModel(List<BusDto> buses){
        List<Bus> list = new ArrayList<Bus>();
        for (BusDto bus : buses) {
            list.add(ToModel(bus));
        }
        return list;
    }
}
