package com.verkeerslicht;

import com.verkeerslicht.constants.PriorityLevel;
import com.verkeerslicht.model.Auto;
import com.verkeerslicht.model.Road;

public class Application {
    public static void main(String[] args) {

        Road noordRoad = new Road("Noord");
        Road zuidRoad = new Road("Zuid");
        Road oostRoad = new Road("Oost");
        Road westRoad = new Road("West");

        noordRoad.addAuto(new Auto(1, "AU1234", "normal", PriorityLevel.AUTO));
        noordRoad.addAuto(new Auto(2, "AU5678", "normal", PriorityLevel.AUTO));
        noordRoad.addAuto(new Auto(3, "AM9012", "ambulance", PriorityLevel.AMBULANCE));
        noordRoad.addAuto(new Auto(4, "AU3456", "normal", PriorityLevel.AUTO));

    }

}