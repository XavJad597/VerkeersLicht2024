package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class OostSensor extends Sensor<Auto> {

    public OostSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate() {
        // Check if there are no vehicles on the road
        if (isEmpty()) {
            getVerkeersLicht().setGreen(false); ;// Skip green light if no vehicles are present
        } else {
            getVerkeersLicht().setGreen(true); // Green light if vehicles are present
        }
    }
 }

