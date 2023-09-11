package com.example.ReservationManagementSysteem.service;

import java.sql.Time;

public class Stopover {
    // Atributos
    private int id;
    private Flight flight;
    private String airportLayover;
    private Time arrivalTime;
    private Time departureTime;


    // Constructor
    public Stopover() {
    }
    public Stopover(int id, Flight flight, String airportLayover, Time arrivalTime, Time departureTime) {
        this.id = id;
        this.flight = flight;
        this.airportLayover = airportLayover;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    // Getters y Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Flight getFlight() {return flight;}
    public void setFlight(Flight flight) {this.flight = flight;}
    public String getAirportLayover() {return airportLayover;}
    public void setAirportLayover(String airportLayover) {this.airportLayover = airportLayover;}
    public Time getArrivalTime() {return arrivalTime;}
    public void setArrivalTime(Time arrivalTime) {this.arrivalTime = arrivalTime;}
    public Time getDepartureTime() {return departureTime;}
    public void setDepartureTime(Time departureTime) {this.departureTime = departureTime;}
}
