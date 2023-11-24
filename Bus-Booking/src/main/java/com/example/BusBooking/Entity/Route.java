package com.example.BusBooking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Entity(name= "Route")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "route_table")
public class Route {
    @Id
    private long id;
    private String originCity;
    private String destinationCity;
    private int travellingPrice;

}
