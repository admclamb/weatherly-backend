package com.weatherly.backend.models;

import com.weatherly.backend.models.common.Alerts;

public class WeatherAggregate {
    private WeatherCurrent current;
    private WeatherDaily daily;
    private WeatherlyHourly hourly;
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

    public WeatherlyHourly getHourly() {
        return hourly;
    }

    public void setHourly(WeatherlyHourly hourly) {
        this.hourly = hourly;
    }

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }
}
