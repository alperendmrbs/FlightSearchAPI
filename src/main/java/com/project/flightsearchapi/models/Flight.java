package com.project.flightsearchapi.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FLIGHTS")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @Column(name = "departure_datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDateTime;

    @Column(name = "return_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDateTime;

    @Column(name = "price", nullable = false)
    private Double price;

}
