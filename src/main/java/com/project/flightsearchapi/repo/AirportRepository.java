package com.project.flightsearchapi.repo;

import com.project.flightsearchapi.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}

