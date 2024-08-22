package com.verkeerslicht.service;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.model.Auto;
import com.verkeerslicht.model.NoordSensor;
import com.verkeerslicht.model.Sensor;

import static com.verkeerslicht.constants.RoadCode.*;

public class VerkeerServiceImpl implements VerkeerService {


    private final Sensor noordSensor;
    private final Sensor oostSensor;
    private final Sensor zuidSensor;
    private final Sensor westSensor;

    public VerkeerServiceImpl(Sensor noordSensor, Sensor oostSensor, Sensor zuidSensor, Sensor westSensor) {
        this.noordSensor = noordSensor;
        this.oostSensor = oostSensor;
        this.zuidSensor = zuidSensor;
        this.westSensor = westSensor;
    }

    @Override
    public void activateSensor(RoadCode roadCode) {
        switch (roadCode) {
            case NOORD:
                noordSensor.activate(NOORD);
                break;
            case OOST:
                oostSensor.activate(OOST);
                break;
            case ZUID:
                zuidSensor.activate(ZUID);
                break;
            case WEST:
                westSensor.activate(WEST);
                break;
            default:
                System.out.println("No sensor found for road code: " + roadCode);
                break;
        }
    }
    @Override
    public void startSequence() {
        activateSensor(NOORD);
        activateSensor(OOST);
        activateSensor(ZUID);
        activateSensor(WEST);

        while (!isQueueEmpty()) {
            Auto auto = processVehicle();
            if (auto != null) {
                System.out.println(auto + " is weggereden.");
            }
        }

        System.out.println("Alle auto's zijn weggereden.");
    }

    @Override
    public void addVehicle(Auto auto) {

    }

    @Override
    public Auto processVehicle() {
        if (!noordSensor.isEmpty() && noordSensor.getVerkeersLicht().isGreen()) {
            return noordSensor.removeVehicle();  // Process vehicle from Noord
        } else if (!oostSensor.isEmpty() && oostSensor.getVerkeersLicht().isGreen()) {
            return oostSensor.removeVehicle();  // Process vehicle from Oost
        } else if (!zuidSensor.isEmpty() && zuidSensor.getVerkeersLicht().isGreen()) {
            return zuidSensor.removeVehicle();  // Process vehicle from Zuid
        } else if (!westSensor.isEmpty() && westSensor.getVerkeersLicht().isGreen()) {
            return westSensor.removeVehicle();  // Process vehicle from West
        }


        return null;  // No vehicle processed if no green light or empty queue
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    @Override
    public boolean isQueueEmpty() {
        return noordSensor.isEmpty() &&
                oostSensor.isEmpty() &&
                zuidSensor.isEmpty() &&
                westSensor.isEmpty();
    }

    @Override
    public void switchTrafficLight() {

    }

    @Override
    public void printQueue() {

    }

}
