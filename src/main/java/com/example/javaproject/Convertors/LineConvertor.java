package com.example.javaproject.Convertors;

import java.util.ArrayList;
import java.util.List;

import com.example.javaproject.DTO.LineDto;
import com.example.javaproject.Models.Line;

public class LineConvertor {
    public LineDto ToDto(Line line) {
        LineDto dto = new LineDto();
        dto.setId(line.getId());
        dto.setDestination(line.getDestination());
        dto.setNumber(line.getNumber());
        dto.setSourse(line.getSourse());
        return dto;
    }

    public Line ToModel(LineDto line) {
        Line model = new Line();
        model.setId(line.getId());
        model.setDestination(line.getDestination());
        model.setNumber(line.getNumber());
        model.setSourse(line.getSourse());
        return model;
    }

    public List<LineDto> ToDto(List<Line> lines){
        List<LineDto> list = new ArrayList<LineDto>();
        for (Line line : lines) {
            list.add(ToDto(line));
        }
        return list;
    }

    public List<Line> ToModel(List<LineDto> lines){
        List<Line> list = new ArrayList<Line>();
        for (LineDto line : lines) {
            list.add(ToModel(line));
        }
        return list;
    }
}
