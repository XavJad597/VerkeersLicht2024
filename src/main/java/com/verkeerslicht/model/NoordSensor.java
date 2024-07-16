package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class NoordSensor extends Sensor<Auto> {

    public NoordSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht, true); // use a queue
    }


    @Override
    public void activate() {
        // check if there are less than 5 vehicles on the road
        if (size()<5) {
            verkeersLicht.setGreen(true); // keep green light until all vehicles have passed
        }
    }
}


