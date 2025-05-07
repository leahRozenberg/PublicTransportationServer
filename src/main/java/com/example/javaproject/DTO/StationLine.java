package com.example.javaproject.DTO;

import lombok.Data;

@Data
public class StationLine {
    private Long Id;
    private Long Station_id;
    private Long Line_id;
    private int StationOrder;
}
