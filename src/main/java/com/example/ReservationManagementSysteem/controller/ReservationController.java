package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.ReservationEntity;
import com.example.ReservationManagementSysteem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flights")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/{code}/reservations")
    public ResponseEntity<?> createReservation(@PathVariable String code, @RequestBody ReservationEntity reservationEntity){
        try {
            ReservationEntity createdReservationEntity = reservationService.createReservation(reservationEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReservationEntity);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
