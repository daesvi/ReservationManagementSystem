package com.example.ReservationManagementSysteem.service;

import com.example.ReservationManagementSysteem.model.UserEntity;
import com.example.ReservationManagementSysteem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
}
