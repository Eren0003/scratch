package com.example.BusBooking.Controller;

import com.example.BusBooking.Entity.*;
import com.example.BusBooking.Response.CancelResponse;
import com.example.BusBooking.Service.BusService;
import com.example.BusBooking.Service.MyUserDetailService;
import com.example.BusBooking.dto.BusDto;
import com.example.BusBooking.dto.Request;
import com.example.BusBooking.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

   @Autowired
    BusService busService;
   @Autowired
    MyUserDetailService myUserDetailService;

    @RequestMapping("/getRoute")
    public ResponseEntity<List<Route>> getRoute(){
        try {
            return new ResponseEntity<List<Route>>(busService.getRoute(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping("/viewBusFrom{origin}To{destination}")
    public ResponseEntity<List<Bus>> viewBus(@PathVariable(value="origin")String origin, @PathVariable(value="destination")String destination){
     try{
        return new ResponseEntity<List<Bus>>(busService.viewBusRoute(origin,destination),HttpStatus.OK);
     }
     catch(Exception e){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/viewTicket/{id}")
    public ResponseEntity<Ticket> viewTicket (@PathVariable(value="id")long id){
        try {
            return new ResponseEntity<Ticket>(busService.viewTicket(id), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("book")
    public ResponseEntity<BusDto> book(@RequestBody UserRequest request){
        try {
            return new ResponseEntity<>(myUserDetailService.book(request), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("cancelBooking")
    public ResponseEntity<CancelResponse> cancelBooking(@RequestBody Request request){
        try {
            return new ResponseEntity<>(busService.cancelBooking(request), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

}
