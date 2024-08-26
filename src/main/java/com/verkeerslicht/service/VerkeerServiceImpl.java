package com.verkeerslicht.service;

import com.verkeerslicht.constants.PriorityLevel;
import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.model.Auto;
import com.verkeerslicht.model.NoordSensor;
import com.verkeerslicht.model.Sensor;

import static com.verkeerslicht.constants.RoadCode.*;

public class VerkeerServiceImpl implements VerkeerService {


    private final Sensor noordSensor;
    private final Sensor oostSensor;
    private final Sensor zuidSensor;
    private final Sensor westSensor;
    private final AutoStack globalStack = new AutoStack();

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
                noordSensor.activate(NOORD,globalStack);
                break;
            case OOST:
                oostSensor.activate(OOST,globalStack);
                break;
            case ZUID:
                zuidSensor.activate(ZUID,globalStack);
                break;
            case WEST:
                westSensor.activate(WEST,globalStack);
                break;
            default:
                System.out.println("No sensor found for road code: " + roadCode);
                break;
        }
    }
    @Override
    public void startSequence() {

        activateAllSensors();
        processHighPriorityVehicles();

        // Process remaining normal vehicles
        while (!isQueueEmpty()) {
            Auto auto = processNormalVehicle();
            if (auto != null) {
                System.out.println(auto + " is weggereden.");
            } else {
                switchTrafficLight();
            }
        }

        System.out.println("Alle auto's zijn weggereden.");
//        activateSensor(OOST);
//        activateSensor(ZUID);
//        activateSensor(WEST);
//        activateSensor(NOORD);
//
//        while (!isQueueEmpty()) {
//            Auto auto = processVehicle();
//            if (auto != null) {
//                System.out.println(auto + " is weggereden.");
//            }
//
//            // Logic to switch to the next traffic light if no vehicle was processed
//            if (auto == null) {
//                switchTrafficLight();
//            }
//        }
//
//        System.out.println("Alle auto's zijn weggereden.");
    }

    @Override
    public void addVehicle(Auto auto) {

    }
     @Override
    public void performReverseSequence() {
        System.out.println("Starting reverse sequence playback...");
        while (!globalStack.isEmpty()) {
            Auto auto = globalStack.pop();
            System.out.println("Auto rijdt weg in omgekeerde volgorde: " + auto);
        }
        System.out.println("Alle auto's zijn weggereden.");
    }

    @Override
    public Auto processVehicle() {
        // Check and process high-priority vehicles first
        Auto vehicleToProcess = null;

        vehicleToProcess = checkAndProcessHighPriorityVehicle(noordSensor);
        if (vehicleToProcess != null) return vehicleToProcess;

        vehicleToProcess = checkAndProcessHighPriorityVehicle(oostSensor);
        if (vehicleToProcess != null) return vehicleToProcess;

        vehicleToProcess = checkAndProcessHighPriorityVehicle(zuidSensor);
        if (vehicleToProcess != null) return vehicleToProcess;

        vehicleToProcess = checkAndProcessHighPriorityVehicle(westSensor);
        if (vehicleToProcess != null) return vehicleToProcess;

        // If no high-priority vehicles, process normal vehicles
        return processNormalVehicle();

//        if (!noordSensor.isEmpty() && noordSensor.getVerkeersLicht().isGreen()) {
//            return noordSensor.removeVehicle();  // Process vehicle from Noord
//        } else if (!oostSensor.isEmpty() && oostSensor.getVerkeersLicht().isGreen()) {
//            return oostSensor.removeVehicle();  // Process vehicle from Oost
//        } else if (!zuidSensor.isEmpty() && zuidSensor.getVerkeersLicht().isGreen()) {
//            return zuidSensor.removeVehicle();  // Process vehicle from Zuid
//        } else if (!westSensor.isEmpty() && westSensor.getVerkeersLicht().isGreen()) {
//            return westSensor.removeVehicle();  // Process vehicle from West
//        }
//
//
//        return null;  // No vehicle processed if no green light or empty queue
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
        if (noordSensor.getVerkeersLicht().isGreen()) {
            noordSensor.getVerkeersLicht().setGreen(false);
            oostSensor.getVerkeersLicht().setGreen(true);
        } else if (oostSensor.getVerkeersLicht().isGreen()) {
            oostSensor.getVerkeersLicht().setGreen(false);
            zuidSensor.getVerkeersLicht().setGreen(true);
        } else if (zuidSensor.getVerkeersLicht().isGreen()) {
            zuidSensor.getVerkeersLicht().setGreen(false);
            westSensor.getVerkeersLicht().setGreen(true);
        } else if (westSensor.getVerkeersLicht().isGreen()) {
            westSensor.getVerkeersLicht().setGreen(false);
            noordSensor.getVerkeersLicht().setGreen(true);
        }

    }

    @Override
    public void printQueue() {

    }

    private Auto checkAndProcessHighPriorityVehicle(Sensor sensor) {
        if (!sensor.isEmpty() && sensor.getVerkeersLicht().isGreen()) {
            Auto auto = sensor.peek();
            if (auto.getPriorityLevel() == PriorityLevel.POLITIE ||
                    auto.getPriorityLevel() == PriorityLevel.BRANDWEER ||
                    auto.getPriorityLevel() == PriorityLevel.AMBULANCE) {
                return sensor.removeVehicle();
            }
        }
        return null;
    }

    private Auto processNormalVehicle() {
        if (!noordSensor.isEmpty() && noordSensor.getVerkeersLicht().isGreen()) {
            return noordSensor.removeVehicle();
        } else if (!oostSensor.isEmpty() && oostSensor.getVerkeersLicht().isGreen()) {
            return oostSensor.removeVehicle();
        } else if (!zuidSensor.isEmpty() && zuidSensor.getVerkeersLicht().isGreen()) {
            return zuidSensor.removeVehicle();
        } else if (!westSensor.isEmpty() && westSensor.getVerkeersLicht().isGreen()) {
            return westSensor.removeVehicle();
        }
        return null;
    }

    private void activateAllSensors() {
        activateSensor(NOORD);
        activateSensor(OOST);
        activateSensor(ZUID);
        activateSensor(WEST);
    }


    private void processHighPriorityVehicles() {
        boolean processed = true;

        while (processed) {
            processed = false;

            Auto vehicleToProcess = checkAndProcessHighPriorityVehicle(noordSensor);
            if (vehicleToProcess != null) {
                processed = true;
                System.out.println(vehicleToProcess + " (high priority) is weggereden.");
                continue;
            }

            vehicleToProcess = checkAndProcessHighPriorityVehicle(oostSensor);
            if (vehicleToProcess != null) {
                processed = true;
                System.out.println(vehicleToProcess + " (high priority) is weggereden.");
                continue;
            }

            vehicleToProcess = checkAndProcessHighPriorityVehicle(zuidSensor);
            if (vehicleToProcess != null) {
                processed = true;
                System.out.println(vehicleToProcess + " (high priority) is weggereden.");
                continue;
            }

            vehicleToProcess = checkAndProcessHighPriorityVehicle(westSensor);
            if (vehicleToProcess != null) {
                processed = true;
                System.out.println(vehicleToProcess + " (high priority) is weggereden.");
            }
        }
    }
}
