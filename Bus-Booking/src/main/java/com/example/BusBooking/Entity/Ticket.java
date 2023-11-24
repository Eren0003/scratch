package com.example.BusBooking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity(name="Ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ticket_table")
public class Ticket {
    @Id
    @GeneratedValue
    private long TicketId;
    private int totalPrice;

    @OneToOne(

            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "userName",
            referencedColumnName = "userName"
    )
    private User userName;

}
