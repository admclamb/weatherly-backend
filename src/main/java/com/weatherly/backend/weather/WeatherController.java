package com.weatherly.backend.weather;

import com.weatherly.backend.models.Units;
import com.weatherly.backend.models.WeatherAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping()
    public ResponseEntity<String> getWeather(@RequestParam(value = "lat", required = true) double lat,
                                                       @RequestParam(value = "lon", required = true) double lon,
                                                       @RequestParam(value = "units", required = true, defaultValue = "STANDARD") Units units) {
        String weatherData = weatherService.getWeather(lat, lon, units);
        if (weatherData != null) {
            return ResponseEntity.ok(weatherData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
