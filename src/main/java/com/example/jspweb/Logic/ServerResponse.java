package com.example.jspweb.Logic;

import java.io.Serializable;

public class ServerResponse implements Serializable {

    public Double x;
    public Double y;
    public Double r;
    public String currentTime;
    public String execTime;
    public boolean bool;

    public ServerResponse (Double x, Double y, Double r, String currentTime, String execTime, boolean bool) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.execTime = execTime;
        this.bool = bool;
    }

}
