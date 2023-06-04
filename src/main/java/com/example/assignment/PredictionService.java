package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PredictionService {

    private final RestTemplate restTemplate;

    @Autowired
    public PredictionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPredictions() {
        String apiUrl = "https://api-v3.mbta.com/predictions?filter[stop]=place-pktrm&sort=departure_time&include=route";
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
