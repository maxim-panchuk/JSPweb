package com.example.jspweb.Logic;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final List<ServerResponse> store = Storage.store;


    public String toString() {
        String resultTable = "";
        for (ServerResponse item : store) {
            resultTable += "<tbody>";
            resultTable += "<td>" + item.x + "</td>";
            resultTable += "<td>" + item.y + "</td>";
            resultTable += "<td>" + item.r + "</td>";
            resultTable += "<td>" + item.currentTime + "</td>";
            resultTable += "<td>" + item.execTime + "</td>";
            resultTable += "<td>" + item.bool + "</td>";
            resultTable += "</tbody>";
        }
        return resultTable;
    }


}
