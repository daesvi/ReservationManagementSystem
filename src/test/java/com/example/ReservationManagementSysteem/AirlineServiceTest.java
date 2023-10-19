package com.example.ReservationManagementSysteem;

import com.example.ReservationManagementSysteem.model.AirlineEntity;
import com.example.ReservationManagementSysteem.repository.AirlineRepository;
import com.example.ReservationManagementSysteem.service.AirlineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirlineServiceTest {

    @InjectMocks
    private AirlineService airlineService;

    @Mock
    private AirlineRepository airlineRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAirline() {
        // Set the AirlineRepository to return the expected airline object when save is called
        AirlineEntity expectedAirline = new AirlineEntity("IBERIA","descripcionejemplo","6543321");
        when(airlineRepository.save(expectedAirline)).thenReturn(expectedAirline);

        // Call the createAirline method and verify that it returns the expected airline
        AirlineEntity result = airlineService.createAirline(expectedAirline);
        assertEquals(expectedAirline, result);
    }

    @Test
    public void testGetAllAirlines() {
        // Set the AirlineRepository to return a list of test airlines
        List<AirlineEntity> expectedAirlines = new ArrayList<>();
        expectedAirlines.add(new AirlineEntity("AVIANCA", "descripcionejemplo", "6543321"));
        expectedAirlines.add(new AirlineEntity("DELTA", "descripcionejemplo", "1234567"));
        when(airlineRepository.findAll()).thenReturn(expectedAirlines);

        // Call the getAirlines method and verify that it returns the expected list of airlines
        List<AirlineEntity> result = airlineService.getAirlines();
        assertEquals(expectedAirlines, result);
    }
}
