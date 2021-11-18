package com.example.jspweb.Logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Checker {
    public String setResults (Parameters parameters) {

        StringBuilder rows = new StringBuilder();
        double startTime = System.nanoTime();
        double x = parameters.x;
        double y = parameters.y;
        double r = parameters.r;
        ServerResponse serverResponse;

        boolean bool = x <= 0 && y >= 0 && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r / 2 ||
                x <= 0 && y <= 0 && x >= -r && y >= -r ||
                x >= 0 && y <= 0 && y >= (x - r);
        String currentTime = new SimpleDateFormat("hh:mm:ss").format(new Date());

        double finishTime = System.nanoTime();
        String execTime = String.format("%4.2f", (finishTime - startTime) / 1000000);

        serverResponse = new ServerResponse(x, y, r, currentTime, execTime, bool);
        rows.append(toJson(serverResponse));

        return rows.toString();
    }

    private static String toJson (ServerResponse serverResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(serverResponse);
    }
}
