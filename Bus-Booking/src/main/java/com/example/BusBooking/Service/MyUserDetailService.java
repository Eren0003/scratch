 package com.example.BusBooking.Service;

import com.example.BusBooking.Entity.*;
import com.example.BusBooking.Repository.BusRepository;
import com.example.BusBooking.Repository.RouteRepository;
import com.example.BusBooking.Repository.TicketRepository;
import com.example.BusBooking.Repository.UserRepository;
import com.example.BusBooking.dto.BusDto;
import com.example.BusBooking.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 @Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusRepository busRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUserName(username)
                .map(MyUserDetail::new)
                .orElseThrow(()->new UsernameNotFoundException("Not Found "+username));
    }

    public BusDto book(UserRequest request) {
        Bus bus = busRepository.findBusById(request.getBusNumber());
        busRepository.decSeat(request.getNoOfSeats(),request.getBusNumber());

        User user = User
                .builder()
                .userName(request.getUserName())
                .bus(bus)
                .noOfSeats(request.getNoOfSeats())
                .role("ROLE_USER")
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        ticketRes(bus,user);
        return busRepository.findQueryByNum_Named(bus.getBusNumber());
//        return user;
    }
    public Ticket ticketRes(Bus bus, User user){
        Ticket ticket = Ticket
                .builder()
                .TicketId(ticketRepository.ticketIncrement())
                .totalPrice(bus.getTotalPrice())
                .userName(user)
                .build();
        ticketRepository.save(ticket);
        return ticket;
    }
}
