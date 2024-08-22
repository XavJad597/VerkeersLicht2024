package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class NoordSensor extends Sensor {

    private Road noordRoad;

    public NoordSensor(VerkeersLicht verkeersLicht,Road noordRoad) {
        super(verkeersLicht);
        this.noordRoad = noordRoad;
    }

    @Override
    public void activate(RoadCode roadCode) {
        if (roadCode == RoadCode.NOORD) {
            // Check if the road is not empty
           if (!noordRoad.isEmpty() && noordRoad.getVoertuigPriorityQueue().size() <5) {
               System.out.println("Er zijn minder dan 5 autos op het wegdek Noord..." + "\n"
                       + "Er moeten " + noordRoad.getVoertuigPriorityQueue().size() + " autos oprijden");


               while (!noordRoad.isEmpty() && ) {
                   Auto auto = noordRoad.removeAuto();
                   System.out.println("Processing auto: " + auto);
                   addVehicle(auto);
               }
           }else if (noordRoad.isEmpty()) {
               System.out.println("Weg dek Noord is leeg... skip naar zuid");
           } else {
               System.out.println("Iets is fout gegaan op wegdek Noord");
           }
        }
        }
    }


