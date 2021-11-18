package com.example.jspweb.Logic;

public class Parameters {
    public Double x;
    public Double y;
    public Double r;

    public Parameters (RequestObject requestObject) {
        this.x = requestObject.getX();
        this.y = requestObject.getY();
        this.r = requestObject.getR();

    }
}
