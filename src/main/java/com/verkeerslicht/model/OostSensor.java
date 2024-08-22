package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class OostSensor extends Sensor{

    public OostSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
    }

    @Override
    public void activate(RoadCode roadCode) {

        if (roadCode == RoadCode.OOST) { // Check if there are no vehicles on the road
            if (isEmpty()) {
                getVerkeersLicht().setGreen(false);
                ;// Skip green light if no vehicles are present
            } else {
                getVerkeersLicht().setGreen(true);
               driveOutVehicles(size());// Green light if vehicles are present
            }
        }
    }
 }

