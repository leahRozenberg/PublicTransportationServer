package com.example.javaproject.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String License_plate;
    private int Seats;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Bus", fetch = FetchType.LAZY)
    private List<Travel> Travels;
}
