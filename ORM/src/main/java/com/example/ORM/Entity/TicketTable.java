package com.example.ORM.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTable {
    @Id
    @GeneratedValue
    private long TicketId;
    private int totalPrice;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "busNumber",
            referencedColumnName ="busNumber"
    )
    private BusTable busTable;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "routeId",
            referencedColumnName = "id"
    )
    private RouteTable routeTable;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "userName",
            referencedColumnName = "userName"
    )
    private UserTable userTable;
}
