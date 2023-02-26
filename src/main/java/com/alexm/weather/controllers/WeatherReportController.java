package com.alexm.weather.controllers;

import com.alexm.weather.services.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
public class WeatherReportController {
    @Autowired
    WeatherReportService weatherReportService;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/")
    public String answer() {
        return "index";
    }

    @ModelAttribute("temp")
    public String getT() {
        return weatherReportService.returnParameterThisHour("temperature_2m");
    }
    @ModelAttribute("cloud")
    public String getC() {
        return weatherReportService.returnParameterThisHour("cloudcover");
    }
    @ModelAttribute("prec")
    public String getP() {
        return weatherReportService.returnParameterThisHour("precipitation");
    }
    @ModelAttribute("wind")
    public String getW() {
        return weatherReportService.returnParameterThisHour("windspeed_10m");
    }
}
