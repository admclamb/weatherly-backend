package com.weatherly.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weatherly.backend.models.common.Alerts;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAggregate {
    private WeatherCurrent current;
    private WeatherDaily daily;
    private WeatherHourly hourly;
    private Alerts alerts;

    public WeatherCurrent getCurrent() {
        return current;
    }

    public void setCurrent(WeatherCurrent current) {
        this.current = current;
    }

    public WeatherDaily getDaily() {
        return daily;
    }

    public void setDaily(WeatherDaily daily) {
        this.daily = daily;
    }

    public WeatherHourly getHourly() {
        return hourly;
    }

    public void setHourly(WeatherHourly hourly) {
        this.hourly = hourly;
    }

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }
}
