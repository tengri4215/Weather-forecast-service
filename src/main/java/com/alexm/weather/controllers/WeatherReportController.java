package com.alexm.weather.controllers;

import com.alexm.weather.services.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;

import java.time.LocalDateTime;

@Controller
public class WeatherReportController {
    @Autowired
    WeatherReportService weatherReportService;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/")
    public String answer(Model model, @RequestParam(value = "time", required = false) String time) {
        //System.out.println(time);
        return "index";
    }

    @PostMapping("/")
    public String post(Model model, @RequestParam(value = "time", required = false) String time) {
        weatherReportService.setTime(Integer.parseInt(time));
        return "redirect:/?time=" + time;
    }

    @ModelAttribute("time")
    public String time() {
        return ((Integer)LocalDateTime.now().getHour()).toString();
    }

    @ModelAttribute("temp")
    public String getT(Model model) {
        return weatherReportService.returnParameter("temperature_2m");
    }
    @ModelAttribute("cloud")
    public String getC(Model model) {
        return weatherReportService.returnParameter("cloudcover");
    }
    @ModelAttribute("prec")
    public String getP(Model model) {
        return weatherReportService.returnParameter("precipitation");
    }
    @ModelAttribute("wind")
    public String getW(Model model) {
        return weatherReportService.returnParameter("windspeed_10m");
    }
}
