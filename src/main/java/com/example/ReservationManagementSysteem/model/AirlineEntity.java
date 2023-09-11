package com.example.ReservationManagementSysteem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "airlines")
public class AirlineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id")
    private int id;

    @Column(name = "airline_name")
    private String nameAirline;

    @Column(name = "airline_description")
    private String description;

    @Column(name = "airline_code")
    private String codeAirline;

    public AirlineEntity() {
    }

    public AirlineEntity(String nameAirline, String description, String codeAirline) {
        this.nameAirline = nameAirline;
        this.description = description;
        this.codeAirline = codeAirline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeAirline() {
        return codeAirline;
    }

    public void setCodeAirline(String codeAirline) {
        this.codeAirline = codeAirline;
    }
}

