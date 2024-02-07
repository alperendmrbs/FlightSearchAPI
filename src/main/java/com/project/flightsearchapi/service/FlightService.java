package com.project.flightsearchapi.service;

// FlightService.java
import com.project.flightsearchapi.models.Flight;
import com.project.flightsearchapi.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> addFlights(List<Flight> flights) { return flightRepository.saveAll(flights); }

    public Flight updateFlight(Long id, Flight flight) {
        if (flightRepository.existsById(id)) {
            flight.setId(id);
            return flightRepository.save(flight);
        }
        return null;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

}
