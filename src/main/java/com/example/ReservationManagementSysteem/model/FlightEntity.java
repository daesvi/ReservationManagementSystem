package com.example.ReservationManagementSysteem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int id;

    @Column(name = "flight_code")
    private String code;

    @Column(name = "flight_origin")
    private String origin;

    @Column(name = "flight_destination")
    private String destination;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "flight_price")
    private double price;

    @Column(name = "available_seats")
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "flight_type_id")
    private FlightTypeEntity type;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineEntity airline;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservations;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<StopoverEntity> stopovers;

    public FlightEntity() {
    }

    public FlightEntity(String code, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, double price, int availableSeats, FlightTypeEntity type, AirlineEntity airline) {
        this.code = code;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.availableSeats = availableSeats;
        this.type = type;
        this.airline = airline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public FlightTypeEntity getType() {
        return type;
    }

    public void setType(FlightTypeEntity type) {
        this.type = type;
    }

    public AirlineEntity getAirline() {
        return airline;
    }

    public void setAirline(AirlineEntity airline) {
        this.airline = airline;
    }
}

