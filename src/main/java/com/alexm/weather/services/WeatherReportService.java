package com.alexm.weather.services;

import com.alexm.weather.apis.OpenMeteoApi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WeatherReportService {

    private int time;
    public String returnParameter(String param) {
        JSONObject hourly = (JSONObject) OpenMeteoApi.makeApiCall().get("hourly");

        JSONArray paramarr = (JSONArray) hourly.get(param);
        return paramarr.get(time).toString();
    }

    public void setTime(int time) {
        this.time = time;
    }
}
