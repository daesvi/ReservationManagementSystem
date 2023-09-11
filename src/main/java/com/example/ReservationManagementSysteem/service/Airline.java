package com.example.ReservationManagementSysteem.service;

public class Airline {
    // Atributos
    private int id;
    private String nameAirline;
    private String description;
    private String codeAirline;

    // Constructor
    public Airline() {}
    public Airline(int id, String nameAirline, String description, String codeAirline) {
        this.id = id;
        this.nameAirline = nameAirline;
        this.description = description;
        this.codeAirline = codeAirline;
    }

    // Getters y Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNameAirline() {return nameAirline;}
    public void setNameAirline(String nameAirline) {this.nameAirline = nameAirline;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getCodeAirline() {return codeAirline;}
    public void setCodeAirline(String codeAirline) {this.codeAirline = codeAirline;}
}
