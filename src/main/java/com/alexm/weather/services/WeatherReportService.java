package com.alexm.weather.services;

import com.alexm.weather.apis.OpenMeteoApi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WeatherReportService {
    public String returnTemperature() {
        JSONObject hourly = (JSONObject) OpenMeteoApi.makeApiCall().get("hourly");

        JSONArray temperature = (JSONArray) hourly.get("temperature_2m");
        return temperature.get(LocalDateTime.now().getHour()).toString();
    }
}
