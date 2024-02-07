package com.project.flightsearchapi.controller;

import com.project.flightsearchapi.models.Airport;
import com.project.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @PostMapping
    public Airport addAirport(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}

