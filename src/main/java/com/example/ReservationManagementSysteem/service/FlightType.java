package com.example.ReservationManagementSysteem.service;

public class FlightType {
    // Atributos
    private int id;
    private String nameType;
    private String descriptionFlight;

    // Constructor
    public FlightType() {
    }
    public FlightType(int id, String nameType, String descriptionFlight) {
        this.id = id;
        this.nameType = nameType;
        this.descriptionFlight = descriptionFlight;
    }

    // Getters y Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNameType() {return nameType;}
    public void setNameType(String nameType) {this.nameType = nameType;}
    public String getDescriptionFlight() {return descriptionFlight;}
    public void setDescriptionFlight(String descriptionFlight) {this.descriptionFlight = descriptionFlight;}
}
