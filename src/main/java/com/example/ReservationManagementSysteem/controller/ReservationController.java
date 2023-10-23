package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.ReservationEntity;
import com.example.ReservationManagementSysteem.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/flights")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Operation(summary = "Get all reservations",
            description = "Gets the list of all reservations registered in the database.")
    @ApiResponse(responseCode = "200", description = "Reservation list successfully obtained",
            content = @Content(schema = @Schema(implementation = ArrayList.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/")
    public ResponseEntity<ArrayList<ReservationEntity>> getAllReservations() {
        ArrayList<ReservationEntity> listReservations = reservationService.getAllReservations();
        return ResponseEntity.status(HttpStatus.OK).body(listReservations);
    }

    @Operation(summary = "Create a reservation",
            description = "Create a new reservation and associate it with a specific code.")
    @ApiResponse(responseCode = "201", description = "Reservation created successfully",
            content = @Content(schema = @Schema(implementation = ReservationEntity.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/{code}/reservations")
    public ResponseEntity<?> createReservation(@Parameter(description = "Flight code for which you wish to make the reservation", required = true)@PathVariable String code, @RequestBody ReservationEntity reservationEntity) {
        try {
            ReservationEntity createdReservationEntity = reservationService.createReservation(reservationEntity, code);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReservationEntity);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
