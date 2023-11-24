package com.example.ORM.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusTable {
    @Id
    @GeneratedValue
    private String busNumber;
    private int totalSeats;
    private int avaliableSeats;
    private String busType;
    private String seatType;
    private int totalPrice;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "routeId",
            referencedColumnName = "id"
    )
    private RouteTable routeTable;

}
