package com.example.javaproject.DTO;

import java.sql.Time;

import lombok.Data;

@Data
public class TravelDto {
    private Long Id;
    private BusDto Bus;
    private DriverDto Driver;
    private LineDto Line;
    private Time DepartureTime;
}
