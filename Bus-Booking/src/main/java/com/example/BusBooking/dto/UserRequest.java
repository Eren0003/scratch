package com.example.BusBooking.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String userName;
    private String password;
    private Integer noOfSeats;
    private String busNumber;
}
