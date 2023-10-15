package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.ReservationEntity;
import com.example.ReservationManagementSysteem.repository.AirlineRepository;
import com.example.ReservationManagementSysteem.service.AirlineService;
import com.example.ReservationManagementSysteem.service.FlightCodeGenerationService;
import com.example.ReservationManagementSysteem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService; // Cambia el nombre y la clase inyectada

    @PostMapping
    public ResponseEntity<?> createFlight(@RequestBody FlightEntity flightEntity) {
        // Create the flight using FlightService
        try {
            FlightEntity createdFlightEntity = flightService.createFlight(flightEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFlightEntity);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<ArrayList<FlightEntity>> getAllFlights(){
        ArrayList<FlightEntity> listFlights = flightService.getAllFlights();
        return ResponseEntity.status(HttpStatus.FOUND).body(listFlights);
    }
}

