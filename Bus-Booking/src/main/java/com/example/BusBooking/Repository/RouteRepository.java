package com.example.BusBooking.Repository;

import com.example.BusBooking.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RouteRepository extends JpaRepository<Route,Integer> {

    @Query(value = "SELECT id FROM route_table  WHERE origin_city = ?1 AND destination_city = ?2 "
            ,nativeQuery = true)
    long findRoute(String origin ,String destination);
    @Query(value = "SELECT * FROM route_table" ,nativeQuery = true)
    List<Route> viewRoute();
    @Query(value = "select * from route_table rt where rt.origin_city = ?1 and rt.destination_city = ?2",
    nativeQuery = true)
    Route findRouteByOD(String origin,String destination);
}
