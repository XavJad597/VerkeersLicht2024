package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class NoordSensor extends Sensor {

    private Road noordRoad;
    private AutoStack autoStack;

    public NoordSensor(VerkeersLicht verkeersLicht,Road noordRoad) {
        super(verkeersLicht);
        this.noordRoad = noordRoad;
        this.autoStack=new AutoStack();

    }

    @Override
    public void activate(RoadCode roadCode,AutoStack globalstack) {
        if (roadCode == RoadCode.NOORD) {
            // Check if the road is not empty
           if (!noordRoad.isEmpty() && noordRoad.getVoertuigPriorityQueue().size() <5) {



               System.out.println("Er zijn minder dan 5 autos op het wegdek Noord..." + "\n"
                       + "Er moeten " + noordRoad.getVoertuigPriorityQueue().size() + " autos oprijden");


               while (!noordRoad.isEmpty()) {
                   Auto auto = noordRoad.removeAuto();

                   if (auto == null) {
                       break;  // Exit the loop if a null Auto is encountered
                   }

                   switch (auto.getPriorityLevel()) {
                       case AUTO:
                           System.out.println("auto rijd weg  van noord: " + auto);
                           break;
                       case AMBULANCE:
                           System.out.println("ambulance rijd weg van noord : " + auto);
                           break;
                       case BRANDWEER:
                           System.out.println(" brandweer rijd weg van noord : " + auto);
                           break;
                       case POLITIE:
                           System.out.println("politie auto rijd weg van noord  " + auto);
                           break;
                   }

                   globalstack.push(auto);  // Push the auto onto the stack
               }

               if (!globalstack.isEmpty()) {
                   getVerkeersLicht().setGreen(true);

           }
               else if (noordRoad.isEmpty()) {
               System.out.println("Weg dek Noord is leeg... skip naar zuid");
           } else {
               System.out.println("Iets is fout gegaan op wegdek Noord");
           }
        }
        }
    }}


