package com.example.ReservationManagementSysteem.controller;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.UserEntity;
import com.example.ReservationManagementSysteem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity userCreated = userService.createUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
