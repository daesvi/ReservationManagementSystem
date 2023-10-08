package com.example.ReservationManagementSysteem.model;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "stopovers")
public class StopoverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stopover_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;

    @Column(name = "airport_layover")
    private String airportLayover;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "departure_time")
    private Time departureTime;

    public StopoverEntity() {
    }

    public StopoverEntity(int id, FlightEntity flightEntity, String airportLayover, Time arrivalTime, Time departureTime) {
        this.id = id;
        this.flightEntity = flightEntity;
        this.airportLayover = airportLayover;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlightEntity getFlight() {
        return flightEntity;
    }

    public void setFlight(FlightEntity flightEntity) {
        this.flightEntity = flightEntity;
    }

    public String getAirportLayover() {
        return airportLayover;
    }

    public void setAirportLayover(String airportLayover) {
        this.airportLayover = airportLayover;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
}
