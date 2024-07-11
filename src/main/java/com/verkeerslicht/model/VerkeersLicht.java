package com.verkeerslicht.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
@Setter
public class VerkeersLicht {
    private String direction; // "North", "South", "East", "West"
    private Queue<Auto> vehiclesQueue;

    public VerkeersLicht(String direction) {
        this.direction = direction;
        this.vehiclesQueue = new LinkedList<>();
    }


    public void processVehicles() {
        int count = 0;
        while (!vehiclesQueue.isEmpty() && count < 5) {
          Auto vehicle = vehiclesQueue.poll();
            System.out.println("Vehicle " + vehicle.getLicensePlate() + " from " + direction + " is moving.");
            count++;
        }
    }
}
