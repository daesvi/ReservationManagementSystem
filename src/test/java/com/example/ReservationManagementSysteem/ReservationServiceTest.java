package com.example.ReservationManagementSysteem;

import com.example.ReservationManagementSysteem.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.ReservationEntity;
import com.example.ReservationManagementSysteem.model.UserEntity;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import com.example.ReservationManagementSysteem.repository.ReservationRepository;
import com.example.ReservationManagementSysteem.repository.UserRepository;

import java.time.LocalDateTime;

public class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateReservation() {
        // Mock data
        String flightCode = "IB0001";
        FlightEntity mockFlight = new FlightEntity();
        mockFlight.setAvailableSeats(1);

        // Flight departs in more than 3 hours
        mockFlight.setDepartureDate(LocalDateTime.now().plusHours(4));

        UserEntity mockUser = new UserEntity();
        ReservationEntity mockReservation = new ReservationEntity();
        mockReservation.setSeatNumber(1);

        // Mock repository behavior
        when(flightRepository.findByCode(flightCode)).thenReturn(mockFlight);
        when(reservationRepository.findByFlightAndSeatNumber(mockFlight, 1)).thenReturn(null);
        when(userRepository.getById(mockReservation.getUserId())).thenReturn(mockUser);
        when(reservationRepository.save(mockReservation)).thenReturn(mockReservation);

        // Test the createReservation method
        ReservationEntity createdReservation = reservationService.createReservation(mockReservation, flightCode);

        // Assertions
        assertNotNull(createdReservation);
    }

    @Test
    public void testCreateReservationWithNoAvailableSeats() {
        // Mock data
        String flightCode = "IB0001";
        FlightEntity mockFlight = new FlightEntity();

        // Set availableSeats to 0
        mockFlight.setAvailableSeats(0);

        UserEntity mockUser = new UserEntity();
        ReservationEntity mockReservation = new ReservationEntity();
        mockReservation.setSeatNumber(1);

        // Mock repository behavior
        when(flightRepository.findByCode(flightCode)).thenReturn(mockFlight);

        // Execute the creation of the reservation
        try {
            ReservationEntity createdReservation = reservationService.createReservation(mockReservation, flightCode);
            fail("Se esperaba una excepción debido a la falta de asientos disponibles.");
        } catch (IllegalArgumentException ex) {
            // Verifies that an exception was thrown and that the exception message indicates that there are no seats available
            assertTrue(ex.getMessage().contains("Uno o más datos de la reserva viola el reglamento"));
        }

        // Verifica que no se haya guardado ninguna reserva en el repositorio
        verify(reservationRepository, never()).save(any(ReservationEntity.class));
    }

    @Test
    public void testCreateReservationWithAlreadyReservedSeat() {
        // Mock data
        String flightCode = "IB0001";
        FlightEntity mockFlight = new FlightEntity();
        mockFlight.setAvailableSeats(10); // Ten available seats

        // The flight leaves in more than 3 hours
        mockFlight.setDepartureDate(LocalDateTime.now().plusHours(4));

        UserEntity mockUser = new UserEntity();
        ReservationEntity mockReservation = new ReservationEntity();
        mockReservation.setSeatNumber(1);

        // Configuring repository behavior
        when(flightRepository.findByCode(flightCode)).thenReturn(mockFlight);

        // Simulates that the seat is already reserved
        when(reservationRepository.findByFlightAndSeatNumber(mockFlight, 1)).thenReturn(new ReservationEntity());
        when(userRepository.getById(mockReservation.getUserId())).thenReturn(mockUser);

        // Check that an exception is thrown when trying to create the reservation
        assertThrows(IllegalArgumentException.class, () -> reservationService.createReservation(mockReservation, flightCode));
    }
}
