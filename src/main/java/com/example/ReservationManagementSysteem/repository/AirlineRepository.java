package com.example.ReservationManagementSysteem.repository;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> { }