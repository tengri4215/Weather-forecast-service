package com.alexm.weather.controllers;

import com.alexm.weather.services.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherReportController {
    @Autowired
    WeatherReportService weatherReportService;

    @GetMapping("/")
    public ResponseEntity answer() {
        return ResponseEntity.ok(weatherReportService.returnTemperature());
    }
}
