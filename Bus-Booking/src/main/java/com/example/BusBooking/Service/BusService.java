package com.example.BusBooking.Service;

import com.example.BusBooking.Entity.Bus;
import com.example.BusBooking.Entity.Route;
import com.example.BusBooking.Entity.Ticket;
import com.example.BusBooking.Entity.User;
import com.example.BusBooking.Repository.BusRepository;
import com.example.BusBooking.Repository.RouteRepository;
import com.example.BusBooking.Repository.TicketRepository;
import com.example.BusBooking.Repository.UserRepository;
import com.example.BusBooking.Response.CancelResponse;
import com.example.BusBooking.dto.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Component
public class BusService {

    @Autowired
    BusRepository busRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;

    public List<Route> getRoute(){
       return routeRepository.findAll();
    }
    public Ticket viewTicket(long id){
        return ticketRepository.findById(id).get();
    }
    public CancelResponse cancelBooking(Request request){
        String userName = request.getName();

        User user = userRepository.findByUser(userName);
        Ticket ticket = ticketRepository.findticketByUserName(userName);

        CancelResponse res = new CancelResponse();
        busRepository.incSeat(user.getNoOfSeats(),user.getBus().getBusNumber());

        ticketRepository.deleteTicket(userName);
        userRepository.deleteUser(userName);

        res.setMsg("Booking Cancelled..");
        return res;
    }
    public List<Bus> viewBusRoute(String origin, String destination) {
        Route route =  routeRepository.findRouteByOD(origin,destination);
        return busRepository.findBusByRoute(route.getId());
    }
}
