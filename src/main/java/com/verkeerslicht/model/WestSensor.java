package com.verkeerslicht.model;


public class WestSensor extends Sensor {

    public WestSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate() {
        // combination of Sensor1 and Sensor2
        OostSensor sensor1 = new OostSensor(verkeersLicht);
        ZuidSensor sensor2 = new ZuidSensor(verkeersLicht);
        sensor1.activate();
        sensor2.activate();
    }
}
