package com.example.BusBooking.Repository;

import com.example.BusBooking.Entity.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query(value = "SELECT COUNT(ticket_id)+1 FROM ticket_table",nativeQuery = true)
    long ticketIncrement();

    @Query(value = "SELECT * FROM  ticket_table WHERE user_name = ?1",nativeQuery = true)
    Ticket findticketByUserName(String userName);
    @Transactional
    @Modifying
    @Query(value = "delete  from ticket_table where user_name = ?1",nativeQuery = true)
    void deleteTicket(String userName);


}
