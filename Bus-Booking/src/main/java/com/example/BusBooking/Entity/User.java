package com.example.BusBooking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="user_table")
public class User {
    @Id
    private String userName;
    @JsonIgnore
    private String password;
    private int noOfSeats;
    private String role;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "busNumber",
            referencedColumnName = "busNumber"
    )
    private Bus bus;

}
