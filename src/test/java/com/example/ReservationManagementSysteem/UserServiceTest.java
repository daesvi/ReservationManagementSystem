package com.example.ReservationManagementSysteem;

import com.example.ReservationManagementSysteem.model.UserEntity;
import com.example.ReservationManagementSysteem.repository.UserRepository;
import com.example.ReservationManagementSysteem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        // Set the UserRepository to return the expected user object when save is called
        UserEntity expectedUser = new UserEntity("daniel", "villegas", "sdas", "213");
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);

        // Call the createUser method and verify that it returns the expected user
        UserEntity result = userService.createUser(expectedUser);
        assertEquals(expectedUser, result);
    }
}
