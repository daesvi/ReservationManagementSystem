package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.ReservationEntity;
import com.example.ReservationManagementSysteem.model.UserEntity;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import com.example.ReservationManagementSysteem.repository.ReservationRepository;
import com.example.ReservationManagementSysteem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    public ArrayList<ReservationEntity> getAllReservations(){
        return (ArrayList<ReservationEntity>) reservationRepository.findAll();
    }

    public ReservationEntity createReservation (ReservationEntity reservationEntity, String code){
        // Search for the flight from the code provided by the endpoint, and get the available seats
        FlightEntity flight = flightRepository.findByCode(code);
        int availableSeats = flight.getAvailableSeats();

        // Get seat number
        int seatNumber = reservationEntity.getSeatNumber();
        // Validation for create a reservation
        if (isFlightValid(reservationEntity, code) && areSeatsAvailable(reservationEntity) && isReservationTimeValid(reservationEntity) && isSeatAvailableInFlight(flight, seatNumber)) {
            // Get and set User from ID
            Long userId = reservationEntity.getUserId();
            UserEntity user = userRepository.getById(userId);
            reservationEntity.setUser(user);

            // Seat is discounted from available seats
            flight.setAvailableSeats(availableSeats-1);

            // Save reservation
            ReservationEntity createdReservationEntity = reservationRepository.save(reservationEntity);
            return createdReservationEntity;
        } else {
            // If you do not meet any validation
            throw new IllegalArgumentException("Uno o más datos de la reserva viola el reglamento para crear la misma");
        }
    }

    private boolean isFlightValid(ReservationEntity reservationEntity, String code) {
        // Validation if flight is valid, and set flight from flightcode
        try {
            FlightEntity flight = flightRepository.findByCode(code);
            reservationEntity.setFlight(flight);
            return true;
        }catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private boolean areSeatsAvailable(ReservationEntity reservationEntity) {
        int availableSeats = reservationEntity.getFlight().getAvailableSeats();
        if (availableSeats >= 1){
            return true;
        }else {
            return false;
        }
    }

    private boolean isSeatAvailableInFlight(FlightEntity flight, int seatNumber) {
        // Query the database to check if the seat number is already reserved on that flight
        ReservationEntity existingReservation = reservationRepository.findByFlightAndSeatNumber(flight, seatNumber);
        return existingReservation == null;
    }

    private boolean isReservationTimeValid(ReservationEntity reservationEntity) {
        FlightEntity flight = reservationEntity.getFlight();
        if (flight != null) {
            // Get the current date and time
            LocalDateTime currentTime = LocalDateTime.now();

            // Get the flight departure date and time
            LocalDateTime flightDepartureTime = flight.getDepartureDate();

            // Calculate the time difference in milliseconds
            long timeDifference = Duration.between(currentTime, flightDepartureTime).toMillis();

            // Check that the difference is greater than 3 hours (in milliseconds)
            if (timeDifference > 3 * 60 * 60 * 1000) {
                reservationEntity.setReservationDate(currentTime);
                return true;
            }
        }
        return false;
    }
}
