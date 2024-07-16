package com.verkeerslicht;

import com.verkeerslicht.model.*;

public class Main {
    public static void main(String[] args) {
        VerkeersLicht verkeersLicht = new VerkeersLicht();

        OostSensor oostSensor = new OostSensor(verkeersLicht);
        ZuidSensor zuidSensor = new ZuidSensor(verkeersLicht);
        WestSensor westSensor = new WestSensor(verkeersLicht);

        // Add some vehicles to the sensors
        oostSensor.addVehicle(new Auto("Car1",));
        oostSensor.addVehicle(new Auto("Car2"));
        zuidSensor.addVehicle(new Auto("Car3"));
        zuidSensor.addVehicle(new Auto("Car4"));
        zuidSensor.addVehicle(new Auto("Car5"));

        // Activate the sensors
        oostSensor.activate();
        zuidSensor.activate();
        westSensor.activate();

        // Print the state of the traffic light
        System.out.println("Traffic light state: " + verkeersLicht.isGreen());

        // Print the vehicles in the West sensor
        System.out.println("Vehicles in West sensor:");
        while (!westSensor.isEmpty()) {
            Auto vehicle = westSensor.removeVehicle();
            System.out.println(vehicle.getLicensePlate());
        }
    }
    }
}