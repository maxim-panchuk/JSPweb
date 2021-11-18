package com.example.jspweb.Logic;

import java.util.ArrayList;
import java.util.List;

public class TestTable {

    private final List<ServerResponse> rows = new ArrayList<>();

    public TestTable (ArrayList<ServerResponse> list) {
        if (list != null) {
            this.rows.addAll(list);
        }
    }

    public String toString() {
        String resultTable = "";
        for (ServerResponse item : rows) {
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
