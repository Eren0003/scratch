package com.example.BusBooking;

import com.example.BusBooking.Service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusBookingApplication  {
	@Autowired
	MyUserDetailService service;

	public static void main(String[] args) {
		SpringApplication.run(BusBookingApplication.class, args);
	}


}
