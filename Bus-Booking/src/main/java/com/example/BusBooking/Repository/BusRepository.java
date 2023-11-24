package com.example.BusBooking.Repository;
import com.example.BusBooking.Entity.Bus;
import com.example.BusBooking.dto.BusDto;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BusRepository extends JpaRepository<Bus,String> {

    @Query(value = "SELECT * FROM bus_table WHERE bus_number = ?1",nativeQuery = true)
    Bus findBusById(String busNumber);

    @Query(value = "SELECT * FROM bus_table WHERE route_id = ?1 AND available_seats > 0",nativeQuery = true)
    List<Bus> findBusByRoute(long routeId);
    @Transactional
    @Modifying
    @Query(value = "UPDATE bus_table SET available_seats = available_seats + ?1 WHERE bus_number = ?2",nativeQuery = true)
    void incSeat (int seats,String busNumber);
    @Transactional
    @Modifying
    @Query(value = "UPDATE bus_table SET available_seats = available_seats - ?1 WHERE bus_number = ?2",nativeQuery = true)
    void decSeat (int seats,String busNumber);

    @Query(value = "select bt.bus_number,bt.total_seats ,bt.bus_type ,bt.route_id ,bt.total_price from bus_table bt where bt.bus_number = ?1",nativeQuery = true)
    Map<String,String> responseBus(String busNumber);

//    @SqlResultSetMapping(
//            name = "BusDtoMapping",
//            classes = {
//                    @ConstructorResult(
//                            targetClass = com.example.BusBooking.dto.BusDto.class,
//                            columns = {
//                                    @ColumnResult(name = "bus_number", type = String.class),
//                                    @ColumnResult(name = "bus_type", type = String.class)
//                            }
//                    )
//            }
//    )
   @Query(nativeQuery = true)
    BusDto findQueryByNum_Named (String busNumber);

}

