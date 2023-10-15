package com.example.ReservationManagementSysteem.repository;

import com.example.ReservationManagementSysteem.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> { }