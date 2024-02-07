package com.project.flightsearchapi.service;

import com.project.flightsearchapi.models.Airport;
import com.project.flightsearchapi.repo.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        if (airportRepository.existsById(id)) {
            airport.setId(id);
            return airportRepository.save(airport);
        }
        return null;
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}

