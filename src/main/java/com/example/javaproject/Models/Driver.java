package com.example.javaproject.Models;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Phone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Driver", fetch = FetchType.LAZY)
    private List<Travel> Travels;
}