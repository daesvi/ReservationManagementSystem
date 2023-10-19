package com.example.ReservationManagementSysteem;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.model.FlightEntity;
import com.example.ReservationManagementSysteem.model.FlightTypeEntity;
import com.example.ReservationManagementSysteem.repository.AirlineRepository;
import com.example.ReservationManagementSysteem.repository.FlightRepository;
import com.example.ReservationManagementSysteem.repository.FlightTypeRepository;
import com.example.ReservationManagementSysteem.service.FlightCodeGenerationService;
import com.example.ReservationManagementSysteem.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightServiceTest {

    @InjectMocks
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private FlightCodeGenerationService flightCodeGenerationService;

    @Mock
    private AirlineRepository airlineRepository;

    @Mock
    private FlightTypeRepository flightTypeRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateFlight() {
        // Set the simulated behavior for the flight code
        AirlineEntity airline = new AirlineEntity();
        airline.setId(1);
        Mockito.when(airlineRepository.getById(1L)).thenReturn(airline);

        FlightTypeEntity flightType = new FlightTypeEntity();
        flightType.setId(1);
        Mockito.when(flightTypeRepository.getById(1L)).thenReturn(flightType);

        Mockito.when(flightCodeGenerationService.generateFlightCode(airline)).thenReturn("ABC123");

        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setAirlineId(1L);
        flightEntity.setTypeId(1L);

        Mockito.when(flightRepository.save(Mockito.any(FlightEntity.class))).thenReturn(flightEntity);

        FlightEntity createdFlight = flightService.createFlight(flightEntity);

        assertNotNull(createdFlight);
        assertEquals("ABC123", createdFlight.getCode());
        assertEquals(airline, createdFlight.getAirline());
        assertEquals(flightType, createdFlight.getType());
    }

    @Test
    public void testGetAllFlights() {
        // Set the simulated behavior to return a list of simulated flights
        ArrayList<FlightEntity> flightList = new ArrayList<>();
        flightList.add(new FlightEntity());
        flightList.add(new FlightEntity());
        Mockito.when(flightRepository.findAll()).thenReturn(flightList);

        ArrayList<FlightEntity> allFlights = flightService.getAllFlights();

        assertEquals(flightList, allFlights);
    }

    @Test
    public void testGetFlightById() {

        Long flightId = 1L;
        FlightEntity flightEntity = new FlightEntity();
        Mockito.when(flightRepository.findById(flightId)).thenReturn(Optional.of(flightEntity));

        FlightEntity foundFlight = flightService.getFlightById(flightId);

        assertNotNull(foundFlight);
        assertEquals(flightEntity, foundFlight);
    }
}
