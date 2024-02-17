package com.weatherly.backend.weather;

import com.weatherly.backend.models.Units;
import com.weatherly.backend.models.WeatherAggregate;
import com.weatherly.backend.openweather.OpenWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final OpenWeatherService openWeatherService;

    public WeatherService(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    public String getWeather(double lat, double lon, Units units) {
        return openWeatherService.getWeatherOneCall(lat, lon, units);
    }
}
