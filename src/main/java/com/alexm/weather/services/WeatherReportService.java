package com.alexm.weather.services;

import com.alexm.weather.apis.OpenMeteoApi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WeatherReportService {
    public String returnParameterThisHour(String param) {
        JSONObject hourly = (JSONObject) OpenMeteoApi.makeApiCall().get("hourly");

        JSONArray paramarr = (JSONArray) hourly.get(param);
        return paramarr.get(LocalDateTime.now().getHour()).toString();
    }
}
