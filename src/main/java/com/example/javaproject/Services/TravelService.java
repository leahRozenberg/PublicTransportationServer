package com.example.javaproject.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaproject.Convertors.TravelConvertor;
import com.example.javaproject.DTO.TravelDto;
import com.example.javaproject.Models.Travel;
import com.example.javaproject.Repositories.TravelRepository;

@Service
public class TravelService {
    @Autowired
    public TravelRepository travelRepository;
    public TravelConvertor travelConvertor;
    public boolean createTravel(TravelDto travel){
        try {
            travelRepository.save(travelConvertor.ToModel(travel));
            return true;
        } catch (Exception e) {
            return false;
        }  
    } 

    public Optional<TravelDto> getById(Long id){
        Optional<Travel> travel = travelRepository.findById(id);
        if (travel.isPresent()) 
            return Optional.of(travelConvertor.ToDto(travel.get()));
        return Optional.empty();
    }
}
