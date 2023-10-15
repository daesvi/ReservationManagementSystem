package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/airlines")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @PostMapping
    public ResponseEntity<AirlineEntity> createAirline(@RequestBody AirlineEntity airlineEntity) {
        AirlineEntity createdAirline = airlineService.createAirline(airlineEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirline);
    }

    @GetMapping
    public ResponseEntity<ArrayList<AirlineEntity>> getAirlines (){
        ArrayList<AirlineEntity> listAirlines = airlineService.getAirlines();
        return ResponseEntity.status(HttpStatus.FOUND).body(listAirlines);
    }
}
