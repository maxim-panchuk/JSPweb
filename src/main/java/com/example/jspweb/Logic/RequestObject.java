package com.example.jspweb.Logic;

import java.util.Arrays;

public class RequestObject {

    Dot dot;
    String[] radius;

    public RequestObject() {}
    public double getX() {return this.dot.getX();}
    public double getY() {return this.dot.getY();}
    public double getR() {return Double.parseDouble(radius[0]);}

    @Override
    public String toString() {
        return "RequestObject{" +
                "dot=" + dot +
                ", r=" + Arrays.toString(radius) +
                '}';
    }

}
