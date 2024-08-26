package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class ZuidSensor extends Sensor {
    private static final int VEHICLE_THRESHOLD = 10;
    private static final int MIN_VEHICLES_TO_LEAVE = 10;
    private Road zuidRoad;

    public ZuidSensor(VerkeersLicht verkeersLicht,Road zuidRoad) {
        super(verkeersLicht);
        this.zuidRoad = zuidRoad;
    }

    @Override
    public void activate(RoadCode roadCode, AutoStack globalStack) {
        if (roadCode == RoadCode.ZUID) {
            int vehiclesProcessed = 0;  // Keep track of how many vehicles have been processed

            // Only activate if there are more vehicles than the threshold
            if (zuidRoad.getVoertuigPriorityQueue().size() > VEHICLE_THRESHOLD) {
                // Process vehicles until we've processed the minimum required or there are no more vehicles
                while (!zuidRoad.getVoertuigPriorityQueue().isEmpty() && vehiclesProcessed < MIN_VEHICLES_TO_LEAVE) {
                    // Keep the light green
                    getVerkeersLicht().setGreen(true);

                    // Remove and process the vehicle
                    Auto auto = zuidRoad.removeAuto();

                    if (auto != null) {
                        System.out.println("Processing auto on ZUID: " + auto);
                        globalStack.push(auto);
                        vehiclesProcessed++;

                        switch (auto.getPriorityLevel()) {
                            case AUTO:
                                System.out.println("Auto rijdt weg van Zuid: " + auto);
                                break;
                            case AMBULANCE:
                                System.out.println("Ambulance rijdt weg van Zuid: " + auto);
                                break;
                            case BRANDWEER:
                                System.out.println("Brandweer rijdt weg van Zuid: " + auto);
                                break;
                            case POLITIE:
                                System.out.println("Politieauto rijdt weg van Zuid: " + auto);
                                break;
                        }
                    }
                }
            }

            // Turn off the light after processing the vehicles in this round
            getVerkeersLicht().setGreen(false);
        }
    }
}
//