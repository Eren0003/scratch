package com.example.BusBooking.Response;

import com.example.BusBooking.Entity.Bus;
import com.example.BusBooking.Entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    User user;
    Bus bus;

}
