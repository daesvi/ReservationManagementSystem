package com.example.ReservationManagementSysteem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "reservation_code")
    private String code;

    @Column(name = "flight_code")
    private String flightCode;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "passenger_first_name")
    private String passengerFirstName;

    @Column(name = "passenger_last_name")
    private String passengerLastName;

    @Column(name = "reservation_state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity client;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;

    public ReservationEntity() {
    }

    public ReservationEntity(String code, String flightCode, LocalDateTime reservationDate, int seatNumber, String passengerFirstName, String passengerLastName, String state, UserEntity client, FlightEntity flight) {
        this.code = code;
        this.flightCode = flightCode;
        this.reservationDate = reservationDate;
        this.seatNumber = seatNumber;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.state = state;
        this.client = client;
        this.flight = flight;
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

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flightEntity) {
        this.flight = flightEntity;
    }
}
