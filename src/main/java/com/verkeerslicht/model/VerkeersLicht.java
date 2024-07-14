package com.verkeerslicht.model;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class VerkeersLicht {
    private boolean isGreen;
    private int timer; // timer for each traffic light

    public  VerkeersLicht() {
        this.isGreen = true;
        this.timer = 5; // initial timer value
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void decrementTimer() {
        timer--;
    }
}
