package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    public AirlineEntity createAirline(AirlineEntity airlineEntity) {
        return airlineRepository.save(airlineEntity);
    }

    public ArrayList<AirlineEntity> getAirlines (){return (ArrayList<AirlineEntity>) airlineRepository.findAll();}
}
