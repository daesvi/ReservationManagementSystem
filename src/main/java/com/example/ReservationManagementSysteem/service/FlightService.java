package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.FlightTypeEntity;
import com.example.ReservationManagementSysteem.repository.AirlineRepository;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import com.example.ReservationManagementSysteem.repository.FlightTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightCodeGenerationService flightCodeGenerationService;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private FlightTypeRepository flightTypeRepository;

    public FlightEntity createFlight(FlightEntity flightEntity) {
        // Get and set Airline from ID
        Long airlineCode = flightEntity.getAirlineId();
        AirlineEntity airline = airlineRepository.getById(airlineCode);
        flightEntity.setAirline(airline);

        // Get and set Type from ID
        Long typeCode = flightEntity.getTypeId();
        FlightTypeEntity type = flightTypeRepository.getById(typeCode);
        flightEntity.setType(type);

        // Flight Code generation
        String flightCode = flightCodeGenerationService.generateFlightCode(airline);
        flightEntity.setCode(flightCode);

        //

        return flightRepository.save(flightEntity);
    }

    public ArrayList<FlightEntity> getAllFlights() {
        // Returns a list of all flights in the database.
        return (ArrayList<FlightEntity>) flightRepository.findAll();
    }

    public FlightEntity getFlightById(Long id) {
        // Get a flight for your ID.
        FlightEntity foundFlight = flightRepository.findById(id).orElse(null);
        if (foundFlight != null){
            return foundFlight;
        }else {
            throw new IllegalArgumentException("El vuelo con el id " + id + " no existe");
        }

    }

    public FlightEntity updateFlight(FlightEntity flightEntity) {

        return null;
    }

}


