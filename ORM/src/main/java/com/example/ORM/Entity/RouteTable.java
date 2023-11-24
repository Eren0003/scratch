package com.example.ORM.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteTable {
    @Id
    @GeneratedValue
    private long id;
    private String originCity;
    private String destinationCity;
    private int travellingPrice;
}
