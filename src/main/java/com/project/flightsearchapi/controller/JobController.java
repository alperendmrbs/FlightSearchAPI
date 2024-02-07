package com.project.flightsearchapi.controller;


import com.project.flightsearchapi.jobs.FlightsFromMockJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    FlightsFromMockJob flightsFromMockJob;

    @GetMapping("/flightsFromMockJob")
    public void runFlightsFromMockJob(){
        flightsFromMockJob.getFlights();
    }
}
