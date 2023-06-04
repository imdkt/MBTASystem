package com.example.assignment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MBTAApiService {
    private final RestTemplate restTemplate;
    private final String mbtaApiUrl = "https://api-v3.mbta.com/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route";

    public MBTAApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Prediction> getPredictions() {
        PredictionResponse response = restTemplate.getForObject(mbtaApiUrl, PredictionResponse.class);
        return response.getPredictions();
    }
}
