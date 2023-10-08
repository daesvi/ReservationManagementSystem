package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.service.FlightCodeGenerationService;
import com.example.ReservationManagementSysteem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService; // Cambia el nombre y la clase inyectada

    @Autowired
    private FlightCodeGenerationService flightCodeGenerationService;

    @PostMapping
    public ResponseEntity<FlightEntity> createFlight(@RequestBody FlightEntity flightEntity) {
        AirlineEntity airline = flightEntity.getAirline();
        String flightCode = flightCodeGenerationService.generateFlightCode(airline);
        flightEntity.setCode(flightCode);
        // Create the flight using FlightService
        FlightEntity createdFlightEntity = flightService.createFlight(flightEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlightEntity);
    }
}

