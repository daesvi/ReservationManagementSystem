package com.example.ReservationManagementSysteem.service;

import java.time.LocalDateTime;

public class Reservation {
    // Atributos
    private String code;
    private String flightCode;
    private LocalDateTime reservationDate;
    private int seatNumber;
    private String passengerFirstName;
    private String passengerLastName;
    private String state;
    private User client;
    private Flight flight;

    // Constructor
    public Reservation() {}
    public Reservation(String code, String flightCode, LocalDateTime reservationDate, int seatNumber, String passengerFirstName, String passengerLastName, String state, User client, Flight flight) {
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

    // Getters y Setters
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getFlightCode() {return flightCode;}
    public void setFlightCode(String flightCode) {this.flightCode = flightCode;}
    public LocalDateTime getReservationDate() {return reservationDate;}
    public void setReservationDate(LocalDateTime reservationDate) {this.reservationDate = reservationDate;}
    public int getSeatNumber() {return seatNumber;}
    public void setSeatNumber(int seatNumber) {this.seatNumber = seatNumber;}
    public String getPassengerFirstName() {return passengerFirstName;}
    public void setPassengerFirstName(String passengerFirstName) {this.passengerFirstName = passengerFirstName;}
    public String getPassengerLastName() {return passengerLastName;}
    public void setPassengerLastName(String passengerLastName) {this.passengerLastName = passengerLastName;}
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
    public User getClient() {return client;}
    public void setClient(User client) {this.client = client;}
    public Flight getFlight() {return flight;}
    public void setFlight(Flight flight) {this.flight = flight;}
}
