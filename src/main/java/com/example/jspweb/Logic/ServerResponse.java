package com.example.jspweb.Logic;

import java.io.Serializable;

public class ServerResponse implements Serializable {

    Double x;
    Double y;
    Double r;
    String currentTime;
    String execTime;
    boolean bool;

    public ServerResponse (Double x, Double y, Double r, String currentTime, String execTime, boolean bool) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.execTime = execTime;
        this.bool = bool;
    }

}
