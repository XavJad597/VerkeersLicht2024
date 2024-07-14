package com.verkeerslicht.model;

public class NoordSensor extends Sensor {

    public NoordSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate() {
        // check if there are less than 5 vehicles on the road
        if (/* less than 5 vehicles on the road */) {
            verkeersLicht.setGreen(true); // keep green light until all vehicles have passed
        }
    }
}


