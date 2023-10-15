package com.example.ReservationManagementSysteem.repository;

import com.example.ReservationManagementSysteem.model.FlightTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTypeRepository extends JpaRepository<FlightTypeEntity, Long> { }