package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.ReservationEntity;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import com.example.ReservationManagementSysteem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    public ReservationEntity createReservation (ReservationEntity reservationEntity){
        if (/*isFlightValid(reservationEntity) && */areSeatsAvailable(reservationEntity) && isReservationTimeValid(reservationEntity)) {
            ReservationEntity createdReservationEntity = reservationRepository.save(reservationEntity);
            return createdReservationEntity;

        } else {
            // If you do not meet any validation
            throw new IllegalArgumentException("Uno o más datos de la reserva viola el reglamento para crear la misma");
        }
    }

//    private boolean isFlightValid(ReservationEntity reservationEntity) {
//        // Validación de existencia del vuelo
//        String flightNumber = reservationEntity.getFlight().getCode();
//        Optional<FlightEntity> optionalFlight = flightRepository.findByFlightNumber(flightNumber);
//
//        return optionalFlight.isPresent();
//    }

    private boolean areSeatsAvailable(ReservationEntity reservationEntity) {
        int availableSeats = reservationEntity.getFlight().getAvailableSeats();
        if (availableSeats >= 1){
            return true;
        }else {
            return false;
        }
    }

    private boolean isReservationTimeValid(ReservationEntity reservationEntity) {
        // Validación de tiempo de reserva
        return true;
    }
}
