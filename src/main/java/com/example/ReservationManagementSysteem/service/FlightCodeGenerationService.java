package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightCodeGenerationService {
    @Autowired
    private FlightRepository flightRepository;

    public String generateFlightCode(Airline airline) {
        // Gets the airline code (first two letters in upper case)
        String airlineCode = airline.getNameAirline().substring(0, 2).toUpperCase();

        // Get the consecutive number
        Long consecutiveCode = flightRepository.countByAirline(airline) + 1;

        // Formats the consecutive number with leading zeros
        String consecutiveCodeFormatted = String.format("%04d", consecutiveCode);

        // Combine airline code and consecutive number
        String flightCode = airlineCode + consecutiveCodeFormatted;

        return flightCode;
    }
}

