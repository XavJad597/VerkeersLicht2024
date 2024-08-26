package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class OostSensor extends Sensor{

    private Road oostRoad;

    public OostSensor(VerkeersLicht verkeersLicht,Road oostRoad) {
        super(verkeersLicht);
        this.oostRoad = oostRoad;
    }

    @Override
    public void activate(RoadCode roadCode, AutoStack globalStack) {

        if (roadCode == RoadCode.OOST) { // Check if there are no vehicles on the road
            if (oostRoad.isEmpty()) {
                getVerkeersLicht().setGreen(false);
                        System.out.println("oost is leeg overslaan");
            } else {
                getVerkeersLicht().setGreen(true);
                while (!oostRoad.isEmpty()) {
                    Auto auto =oostRoad.removeAuto();
                    // Remove vehicle from queue

                    if (auto == null) {
                        break;
                    }

                    System.out.println(" auto rijd van OOST: " + auto);
                    globalStack.push(auto);  // Push the auto onto the global stack
                }

                getVerkeersLicht().setGreen(false);
            }
            }
        }
    }

