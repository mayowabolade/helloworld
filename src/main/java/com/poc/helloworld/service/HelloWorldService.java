package com.poc.helloworld.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.text.SimpleDateFormat;

@Service
public class HelloWorldService {

    public JSONObject fetchRightGreeting() throws JSONException {
        Calendar calendar = Calendar.getInstance();

        // Get current date and time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
        String currentDate = dateFormatter.format(calendar.getTime());

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String currentTime = timeFormatter.format(calendar.getTime());

        // Determine the time period (morning, afternoon, evening)
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String period;
        if (hour >= 0 && hour < 12) {
            period = "morning";
        } else if (hour >= 12 && hour < 16) {
            period = "afternoon";
        } else {
            period = "evening";
        }

        // Create JSON object
        JSONObject json = new JSONObject();
        json.put("date", currentDate);
        json.put("time", currentTime);
        json.put("greeting", "Hello world! Good " + period);
        System.out.println("json response =" + json);
        return json;
    }

    public String getTimeOfDay() {
        Calendar calendar = Calendar.getInstance();

        // Get current date and time
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
        String currentDate = dateFormatter.format(calendar.getTime());

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String currentTime = timeFormatter.format(calendar.getTime());

        // Determine the time period (morning, afternoon, evening)
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String period;
        if (hour >= 0 && hour < 12) {
            period = "morning";
        } else if (hour >= 12 && hour < 16) {
            period = "afternoon";
        } else {
            period = "evening";
        }

        // Return the formatted message
        return "Hello world! Today's date is " + currentDate + ". The time is " + currentTime + ". Good " + period + ".";
    }
}