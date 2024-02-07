package com.project.flightsearchapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.flightsearchapi.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
