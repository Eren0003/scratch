package com.example.BusBooking.Entity;

import com.example.BusBooking.dto.BusDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;


@NamedNativeQuery(
        name = "Bus.findQueryByNum_Named",
        query = "select bus_number as num , bus_type as type from bus_table where bus_number = ?1",
        resultSetMapping = "Mapping.QueryByNum")
@SqlResultSetMapping(
        name = "Mapping.QueryByNum",
        classes = @ConstructorResult(
                targetClass = BusDto.class,
                columns = {@ColumnResult(name = "num"),
                           @ColumnResult(name = "type")}
        )
)
@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="bus_table")
public class Bus {
    @Id
    private String busNumber;
    private int totalSeats;
    private int availableSeats;
    private String busType;
    private String seatType;
    private int totalPrice;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "routeId",
            referencedColumnName = "id"
    )
    private Route route;
}
