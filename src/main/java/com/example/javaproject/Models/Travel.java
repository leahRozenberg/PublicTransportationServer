package com.example.javaproject.Models;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "Bus_id")
    private Bus Bus;

    @ManyToOne
    @JoinColumn(name = "Driver_id")
    private Driver Driver;

    @ManyToOne
    @JoinColumn(name = "Line_id")
    private Line Line;
    private Time DepartureTime;
    
}
