package com.verkeerslicht.model;

public class ZuidSensor extends Sensor{
    public ZuidSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate() {
        // check if there are more than 10 vehicles on the road
        if (/* more than 10 vehicles on the road */) {
           verkeersLicht.setGreen(true); // keep green light until 10 vehicles have passed
        }
    }
}
//
//Based on the description, Sensor1 is associated with the East road, Sensor2 is associated with the South road, Sensor3 is associated with the West road, and Sensor4 is associated with the North road.
//
//        So, Sensor1 is the sensor for the East road, which checks if there are any vehicles present on the road before turning the green light on. If there are no vehicles present, the green light will be skipped once.
//
//
//
//
//Answer with Web Search
//
