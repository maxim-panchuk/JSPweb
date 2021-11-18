package com.example.jspweb.Logic;

public class LastDots {

    public Double x;
    public Double y;
    public Double r;
    public boolean bool;

    public LastDots (ServerResponse serverResponse) {
        this.x = serverResponse.x;
        this.y = serverResponse.y;
        this.r = serverResponse.r;
        this.bool = serverResponse.bool;
    }


}
