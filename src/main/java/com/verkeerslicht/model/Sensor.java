package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.PriorityQueue;
import com.verkeerslicht.datastructures.Queue;
import com.verkeerslicht.datastructures.AutoStack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Sensor {

    private VerkeersLicht verkeersLicht;
    private PriorityQueue queue;
    private AutoStack autoStack;


    public Sensor(VerkeersLicht verkeersLicht) {
        this.verkeersLicht = verkeersLicht;
        this.queue = new PriorityQueue();
    }

    public Sensor() {
        this.queue = new PriorityQueue();
    }

    public abstract void activate(RoadCode roadCode);

    public void addVehicle(Auto auto) {
        if (auto != null) {
            queue.insert(auto);
        } else {
            throw new UnsupportedOperationException("Only Auto objects can be added to the sensor");
        }
    }

    public Auto removeVehicle() {
        return  queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    protected void driveOutVehicles(int maxVehicles) {
        if (getVerkeersLicht().isGreen()) {
            int vehiclesToDriveOut = Math.min(maxVehicles, size());
            for (int i = 0; i < vehiclesToDriveOut; i++) {
                Auto vehicle = removeVehicle();
                // Process vehicle driving away (e.g., update status, print message)
                System.out.println(vehicle + " is driving away.");
            }
            getVerkeersLicht().setGreen(false); // Turn off the green light after processing
        }
    }
}
