package com.example.ReservationManagementSysteem.repository;

import com.example.ReservationManagementSysteem.service.Airline;
import com.example.ReservationManagementSysteem.service.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight, Long> {
    Long countByAirline(Airline airline);
}