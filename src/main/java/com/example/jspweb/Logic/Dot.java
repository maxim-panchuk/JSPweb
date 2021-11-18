package com.example.jspweb.Logic;

public class Dot {
    String name;
    String x;
    String y;

    public Dot() {
    }

    public double getX() {return Double.parseDouble(this.x);}
    public double getY() {return Double.parseDouble(this.y);}

    @Override
    public String toString() {
        return "Dot{" +
                "name='" + name + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
