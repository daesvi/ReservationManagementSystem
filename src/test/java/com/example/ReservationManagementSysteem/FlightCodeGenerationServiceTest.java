package com.example.ReservationManagementSysteem;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import com.example.ReservationManagementSysteem.service.FlightCodeGenerationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightCodeGenerationServiceTest {

    @InjectMocks
    private FlightCodeGenerationService flightCodeGenerationService;

    @Mock
    private FlightRepository flightRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateFlightCode() {
        // Create an airline entity to use in the test
        AirlineEntity airline = new AirlineEntity();
        airline.setNameAirline("American Airlines");

        // Configure the behavior of flightRepository.countByAirline to return a specific value
        when(flightRepository.countByAirline(airline)).thenReturn(3L);

        // Call the generateFlightCode method and verify that it returns the expected flight code
        String expectedFlightCode = "AM0004"; // Según el comportamiento simulado
        String generatedFlightCode = flightCodeGenerationService.generateFlightCode(airline);
        assertEquals(expectedFlightCode, generatedFlightCode);
    }
}
