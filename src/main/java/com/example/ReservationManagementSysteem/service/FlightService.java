package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(Flight flight) {

        return null;
    }

    public List<Flight> getAllFlights() {
        // Returns a list of all flights in the database.
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        // Get a flight for your ID.
        return flightRepository.findById(id).orElse(null);
    }

    public Flight updateFlight(Flight flight) {

        return null;
    }

}


