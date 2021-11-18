package com.example.jspweb.Logic;

import java.util.ArrayList;
import java.util.List;

public class SvgUpdater {
    List<ServerResponse> lastDotsList = new ArrayList<>();
    public static double currentR = 2;


    public SvgUpdater(ArrayList<ServerResponse> list) {
        if (list != null) {
            this.lastDotsList.addAll(list);
        }

    }

    public String toString () {
        String resultSvg = "";

        for (ServerResponse item : lastDotsList) {
            item.r = currentR;
            item.bool =  item.x <= 0 && item.y >= 0 && Math.sqrt(Math.pow(item.x, 2) + Math.pow(item.y, 2)) <= currentR / 2 ||
                    item.x <= 0 && item.y <= 0 && item.x >= -currentR && item.y >= -currentR ||
                    item.x >= 0 && item.y <= 0 && item.y >= (item.x - currentR);
        }


        for (ServerResponse item : lastDotsList) {
            double xCor = (item.x * ((350 - 70) / 2) / item.r) + 175;
            double yCor = (350 / 2 - (item.y * ((350 - 70) / 2) / item.r));
            /*resultSvg += "<circle class=\"coordinate-dot\" r=\"" + item.r + "\" cx=\"" + item.x * (140 / item.r) + 175 + "\" cy=\""
                    + -(item.y * 140/ item.r) + 175 + "\" stroke=" + (item.bool ? "\"green\"" : "\"red\"") + " fill="
                    + (item.bool ? "\"green\"" : "\"red\"") + "></circle>\n";*/

            resultSvg += "<circle class=\"coordinate-dot\" r=\"" + 2.5 + "\" cx=\"" + xCor + "\" cy=\""
                    + yCor + "\" stroke=" + (item.bool ? "\"green\"" : "\"red\"") + " fill="
                    + (item.bool ? "\"green\"" : "\"red\"") + "></circle>\n";
        }
        return resultSvg;
    }
}
