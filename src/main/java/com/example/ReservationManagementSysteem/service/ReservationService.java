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
        FlightEntity flight = flightRepository.findByCode(code);
        int availableSeats = flight.getAvailableSeats();
        // Validation for create a reservation
        if (isFlightValid(reservationEntity, code) && areSeatsAvailable(reservationEntity) && isReservationTimeValid(reservationEntity)) {
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

    private boolean isReservationTimeValid(ReservationEntity reservationEntity) {
        FlightEntity flight = reservationEntity.getFlight();
        if (flight != null) {
            // Obtener la fecha y hora actual
            LocalDateTime currentTime = LocalDateTime.now();

            // Obtener la fecha y hora de salida del vuelo
            LocalDateTime flightDepartureTime = flight.getDepartureDate();

            // Calcular la diferencia de tiempo en milisegundos
            long timeDifference = Duration.between(currentTime, flightDepartureTime).toMillis();

            // Comprobar que la diferencia sea mayor de 3 horas (en milisegundos)
            if (timeDifference > 3 * 60 * 60 * 1000) {
                reservationEntity.setReservationDate(currentTime);
                return true;
            }
        }
        return false;
    }
}
