package com.example.javaproject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.javaproject.Convertors.BusConvertor;
import com.example.javaproject.DTO.BusDto;
import com.example.javaproject.Models.Bus;
import com.example.javaproject.Repositories.BusRepository;

@Service
public class BusService {
    
    @Autowired
    public BusRepository busRepository;
    @Autowired
    public BusConvertor busConvertor;
    public Optional<List<BusDto>> getBySeats(int seats){
        Bus example = new Bus();
        example.setSeats(seats);
        List<Bus> buses = busRepository.findAll(Example.of(example));
        if(buses.size()>0)
            return Optional.of(busConvertor.ToDto(buses));
        return Optional.empty();
    }

    public Optional<Bus> add(BusDto bus){
        try {
            Bus temp = busRepository.save(busConvertor.ToModel(bus));
            return Optional.of(temp);
        } catch (Exception e) {
            return Optional.empty();
        }
        
    }
}
