package com.verkeerslicht.app;

import com.verkeerslicht.constants.PriorityLevel;
import com.verkeerslicht.model.Auto;
import com.verkeerslicht.model.Road;

public class Application {
    public static void main(String[] args) {

        Road noordRoad = new Road("Noord");
        Road zuidRoad = new Road("Zuid");
        Road oostRoad = new Road("Oost");
        Road westRoad = new Road("West");

        noordRoad.addAuto(new Auto(1, "AU1234", PriorityLevel.AUTO));
        noordRoad.addAuto(new Auto(2, "AU5678", PriorityLevel.AUTO));
        noordRoad.addAuto(new Auto(3, "AM9012", PriorityLevel.AMBULANCE));
        noordRoad.addAuto(new Auto(4, "AU3456", PriorityLevel.AUTO));
        for (int i = 1; i <= 16; i++) {
            zuidRoad.addAuto(new Auto(i, "AU" + i + "X", PriorityLevel.AUTO));
        }
        zuidRoad.addAuto(new Auto(17, "BR1234", PriorityLevel.BRANDWEER));
        zuidRoad.addAuto(new Auto(18, "AU7890", PriorityLevel.AUTO));

        // Add vehicles to Oost road
        for (int i = 1; i <= 5; i++) {
            oostRoad.addAuto(new Auto(i, "AU" + i + "Y", PriorityLevel.AUTO));
        }

        // Add vehicles to West road
        for (int i = 1; i <= 8; i++) {
            westRoad.addAuto(new Auto(i, "AU" + i + "Z", PriorityLevel.AUTO));
        }
        westRoad.addAuto(new Auto(9, "PO1234", PriorityLevel.POLITIE));
        for (int i = 10; i <= 14; i++) {
            westRoad.addAuto(new Auto(i, "AU" + i + "W", PriorityLevel.AUTO));
        }

        // Test the setup
        System.out.println("Noord Road: " + noordRoad);
        System.out.println("Zuid Road: " + zuidRoad);
        System.out.println("Oost Road: " + oostRoad);
        System.out.println("West Road: " + westRoad);

    }

}