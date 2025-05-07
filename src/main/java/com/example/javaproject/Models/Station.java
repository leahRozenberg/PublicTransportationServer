package com.example.javaproject.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "Stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; 
    private String Name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Station_id", fetch=FetchType.LAZY)
    List<StationLine> StationLines;
}
