package com.example.ORM.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTable {
    @Id
    private String userName;
    private String password;
    private int noOfSeats;
    private String role;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "busNumber",
            referencedColumnName = "busNumber"
    )
    private BusTable busTable;
}
