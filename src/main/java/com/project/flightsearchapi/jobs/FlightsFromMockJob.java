package com.project.flightsearchapi.jobs;

import com.project.flightsearchapi.models.Flight;
import com.project.flightsearchapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Component
public class FlightsFromMockJob {

    @Autowired
    private FlightService flightService;

    //Can be set in properties file
    private final String MOCK_API_URL = "https://5e37727f-c12c-440b-bfa3-b16a2ebb9d18.mock.pstmn.io/flights";

    @Scheduled(cron = "0 0 8 * * *")
    public void getFlights(){
        RestTemplate restTemplate = new RestTemplate();
        Flight[] flights = restTemplate.getForObject(MOCK_API_URL, Flight[].class);
        flightService.addFlights(Arrays.asList(flights));
    }
}
