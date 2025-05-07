package com.example.javaproject.Convertors;

import java.util.ArrayList;
import java.util.List;

import com.example.javaproject.DTO.DriverDto;
import com.example.javaproject.Models.Driver;

public class DriverConvertor {
    public DriverDto ToDto(Driver driver) {
        DriverDto dto = new DriverDto();
        dto.setId(driver.getId());
        dto.setName(driver.getName());
        dto.setPhone(driver.getPhone());
        return dto;
    }

    public Driver ToModel(DriverDto driver) {
        Driver model = new Driver();
        model.setId(driver.getId());
        model.setName(driver.getName());
        model.setPhone(driver.getPhone());
        return model;
    }

    public List<DriverDto> ToDto(List<Driver> drivers){
        List<DriverDto> list = new ArrayList<DriverDto>();
        for (Driver driver : drivers) {
            list.add(ToDto(driver));
        }
        return list;
    }

    public List<Driver> ToModel(List<DriverDto> drivers){
        List<Driver> list = new ArrayList<Driver>();
        for (DriverDto driver : drivers) {
            list.add(ToModel(driver));
        }
        return list;
    }
}
