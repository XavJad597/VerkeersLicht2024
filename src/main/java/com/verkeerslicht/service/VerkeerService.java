package com.verkeerslicht.service;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.model.Auto;

public interface VerkeerService {

    void activateSensor(RoadCode roadCode);

    void startSequence();

    void addVehicle(Auto auto);  // Add a vehicle to the queue

    Auto processVehicle();  // Process a vehicle from the queue (FIFO)

    int getQueueSize();  // Get the current size of the queue

    boolean isQueueEmpty();  // Check if the queue is empty

    void switchTrafficLight();  // Switch traffic light to the next road

    void printQueue();  // Print the current state of the queue (optional for debugging)


}
