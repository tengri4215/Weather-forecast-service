package com.alexm.weather.apis;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class OpenMeteoApi {
    public static JSONObject makeApiCall() {

        String output = "";
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=53.90&longitude=27.57&hourly=temperature_2m,precipitation,weathercode,cloudcover,windspeed_10m&daily=weathercode&current_weather=true&timezone=auto");
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            output = content.toString();
            bufferedReader.close();

            JSONObject jsonobject = (JSONObject) (new JSONParser().parse(output));

            return jsonobject;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONObject();
    }
}
