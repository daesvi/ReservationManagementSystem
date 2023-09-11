package com.example.ReservationManagementSysteem.service;

import java.time.LocalDateTime;

public class Flight {
    // Atributos
    private int id;
    private String code;
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private double price;
    private int availableSeats;
    private FlightType type;
    private Airline airline;

    // Constructor
    public Flight() {}

    public Flight(int id, String code, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, double price, int availableSeats, FlightType type, Airline airline) {
        this.id = id;
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

    // Getters y Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getOrigin() {return origin;}
    public void setOrigin(String origin) {this.origin = origin;}
    public String getDestination() {return destination;}
    public void setDestination(String destination) {this.destination = destination;}
    public LocalDateTime getDepartureDate() {return departureDate;}
    public void setDepartureDate(LocalDateTime departureDate) {this.departureDate = departureDate;}
    public LocalDateTime getArrivalDate() {return arrivalDate;}
    public void setArrivalDate(LocalDateTime arrivalDate) {this.arrivalDate = arrivalDate;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getAvailableSeats() {return availableSeats;}
    public void setAvailableSeats(int availableSeats) {this.availableSeats = availableSeats;}
    public FlightType getType() {return type;}
    public void setType(FlightType type) {this.type = type;}
    public Airline getAirline() {return airline;}
    public void setAirline(Airline airline) {this.airline = airline;}
}
