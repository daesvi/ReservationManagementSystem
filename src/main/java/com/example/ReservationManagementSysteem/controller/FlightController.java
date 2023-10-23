package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Operation(summary = "Create a flight",
            description = "Creates a new flight and saves it to the database.")
    @ApiResponse(responseCode = "201", description = "Flight created successfully",
            content = @Content(schema = @Schema(implementation = FlightEntity.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
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

    @Operation(summary = "Get all flights",
            description = "Gets the list of all flights registered in the database.")
    @ApiResponse(responseCode = "200", description = "Flight list successfully obtained",
            content = @Content(schema = @Schema(implementation = ArrayList.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping
    public ResponseEntity<ArrayList<FlightEntity>> getAllFlights() {
        ArrayList<FlightEntity> listFlights = flightService.getAllFlights();
        return ResponseEntity.status(HttpStatus.OK).body(listFlights);
    }

    @Operation(summary = "Get flight by ID",
            description = "Get a flight by your ID, provided through the endpoint")
    @ApiResponse(responseCode = "200", description = "Flight found successfully",
            content = @Content(schema = @Schema(implementation = FlightEntity.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Flight not found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/{id}")
    public ResponseEntity<?> getFlightById(@Parameter(description = "Flight ID", required = true)@PathVariable Long id) {
        try {
            FlightEntity foundFlight = flightService.getFlightById(id);
            return ResponseEntity.status(HttpStatus.OK).body(foundFlight);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}

