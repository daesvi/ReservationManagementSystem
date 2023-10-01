package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.dto.FlightDetailDTO;
import com.example.ReservationManagementSysteem.service.Airline;
import com.example.ReservationManagementSysteem.service.Flight;
import com.example.ReservationManagementSysteem.service.FlightCodeGenerationService;
import com.example.ReservationManagementSysteem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService; // Cambia el nombre y la clase inyectada

    @Autowired
    private FlightCodeGenerationService flightCodeGenerationService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Airline airline = flight.getAirline();
        String flightCode = flightCodeGenerationService.generateFlightCode(airline);
        flight.setCode(flightCode);

        // Create the flight using FlightService
        Flight createdFlight = flightService.createFlight(flight);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDetailDTO> getFlightDetailById(@PathVariable Long id) {
        // Call FlightService to get the flight by flight ID
        Flight flight = flightService.getFlightById(id);

        if (flight != null) {
            // Map Flight object to FlightDetailDTO
            FlightDetailDTO flightDetailDTO = mapFlightToFlightDetailDTO(flight);

            return ResponseEntity.ok(flightDetailDTO); // Returns flight detail in JSON format
        } else {
            return ResponseEntity.notFound().build(); // Returns a 404 response if the flight is not found.
        }
    }

    // Method to map a Flight object to FlightDetailDTO
    private FlightDetailDTO mapFlightToFlightDetailDTO(Flight flight) {
        FlightDetailDTO flightDetailDTO = new FlightDetailDTO();
        flightDetailDTO.setId(flight.getId());
        flightDetailDTO.setOrigin(flight.getOrigin());
        flightDetailDTO.setDestination(flight.getDestination());
        flightDetailDTO.setDepartureDate(flight.getDepartureDate());
        flightDetailDTO.setArrivalDate(flight.getArrivalDate());
        flightDetailDTO.setPrice(flight.getPrice());
        flightDetailDTO.setAvailableSeats(flight.getAvailableSeats());
        flightDetailDTO.setType(flight.getType().toString()); // Convert FlightType to String
        flightDetailDTO.setAirline(flight.getAirline().getNameAirline());
        return flightDetailDTO;
    }

}

