package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class NoordSensor extends Sensor<Auto> {

    public NoordSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate() {
        // Check if there are less than 5 vehicles on the road
        if (size() < 5) {
            // Keep the light green until all vehicles have driven away
            while (!isEmpty()) {
                getVerkeersLicht().setGreen(true); // Ensure the light stays green
                removeVehicle(); // Auto rijd weg
            }
            // All vehicles have left, turn the light red
            getVerkeersLicht().setGreen(false);
        } else {
            // If there are 5 or more vehicles, do not change the light
            getVerkeersLicht().setGreen(false);
        }
    }
}


