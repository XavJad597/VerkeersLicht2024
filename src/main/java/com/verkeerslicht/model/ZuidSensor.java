package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class ZuidSensor extends Sensor<Auto> {
    private static final int VEHICLE_THRESHOLD = 10;
    private static final int MIN_VEHICLES_TO_LEAVE = 10;

    public ZuidSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate() {
        // Check if there are more than 10 vehicles on the road
        if (size() > VEHICLE_THRESHOLD) {
            // Ensure the light remains green until at least 10 vehicles have left
            while (size() > VEHICLE_THRESHOLD - MIN_VEHICLES_TO_LEAVE) {
                // Keep the light green
                getVerkeersLicht().setGreen(true);
                // Simulate the process of vehicles passing
                removeVehicle(); // This assumes that vehicles leave one by one
                // Optionally: Implement a delay or timer to manage the time
            }
        } else {
            getVerkeersLicht().setGreen(true); // Ensure the light is green if within the normal range
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
