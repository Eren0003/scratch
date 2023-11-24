package com.example.BusBooking.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private String userName;
    private String busNumber;
    private int noOfSeats;
    private int totalPrice;
    private int ticketId;
    private String busType;
    private String seatType;
    private String originCity;
    private String destinationCity;

}
