package com.example.ReservationManagementSysteem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flights_type")
public class FlightTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_type_id")
    private int id;

    @Column(name = "type_name")
    private String nameType;

    @Column(name = "flight_description")
    private String descriptionFlight;

    public FlightTypeEntity() {
    }

    public FlightTypeEntity(String nameType, String descriptionFlight) {
        this.nameType = nameType;
        this.descriptionFlight = descriptionFlight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getDescriptionFlight() {
        return descriptionFlight;
    }

    public void setDescriptionFlight(String descriptionFlight) {
        this.descriptionFlight = descriptionFlight;
    }
}

