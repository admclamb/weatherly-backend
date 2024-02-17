package com.weatherly.backend.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherly.backend.models.Units;
import com.weatherly.backend.models.WeatherAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class OpenWeatherService {
    private static final Logger log = LoggerFactory.getLogger(OpenWeatherService.class);

    @Qualifier("openWeatherRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("openWeatherApiKey")
    private String apiKey;

    public String getWeatherOneCall(double lat, double lon, Units units) {
        String path = "/data/3.0/onecall";
        String url = UriComponentsBuilder.fromPath(path)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("units", units.toString().toLowerCase())
                .queryParam("appid", apiKey)
                .toUriString();

        try {
           return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            log.error("Error calling OpenWeather API: {}", e.getMessage());
            return null;
        }
    }

}
