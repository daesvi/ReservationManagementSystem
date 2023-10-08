package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public FlightEntity createFlight(FlightEntity flightEntity) {
        return flightRepository.save(flightEntity);
    }

    public List<FlightEntity> getAllFlights() {
        // Returns a list of all flights in the database.
        return flightRepository.findAll();
    }

    public FlightEntity getFlightById(Long id) {
        // Get a flight for your ID.
        return flightRepository.findById(id).orElse(null);
    }

    public FlightEntity updateFlight(FlightEntity flightEntity) {

        return null;
    }

}


