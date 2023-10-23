package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.service.AirlineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/airlines")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @Operation(summary = "Create an airline",
        description = "Creates a new airline and saves it to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created airline",
                    content = @Content(schema = @Schema(implementation = AirlineEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PostMapping
    public ResponseEntity<AirlineEntity> createAirline(@RequestBody AirlineEntity airlineEntity) {
        AirlineEntity createdAirline = airlineService.createAirline(airlineEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirline);
    }

    @Operation(summary = "Get all airlines",
            description = "Gets the list of all airlines registered in the database.")
    @ApiResponse(responseCode = "200", description = "Successfully obtained airline list",
            content = @Content(schema = @Schema(implementation = ArrayList.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping
    public ResponseEntity<ArrayList<AirlineEntity>> getAirlines() {
        ArrayList<AirlineEntity> listAirlines = airlineService.getAirlines();
        return ResponseEntity.status(HttpStatus.OK).body(listAirlines);
    }
}
