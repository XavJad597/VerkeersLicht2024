package com.verkeerslicht.model;


import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.LinkedList;


public class WestSensor extends Sensor {


    private OostSensor oostSensor;
    private ZuidSensor zuidSensor;

    public WestSensor(VerkeersLicht verkeersLicht, LinkedList node) {
        super(verkeersLicht);
        this.oostSensor = new OostSensor(verkeersLicht);
        this.zuidSensor = new ZuidSensor(verkeersLicht);
    }

    public WestSensor(VerkeersLicht verkeersLicht) {
        super(verkeersLicht);
        this.oostSensor = new OostSensor(verkeersLicht);
        this.zuidSensor = new ZuidSensor(verkeersLicht);
    }

    @Override
    public void activate(RoadCode roadCode) {
        if (roadCode == RoadCode.WEST) {
            // Activate both OostSensor and ZuidSensor
            oostSensor.activate(RoadCode.OOST);
            zuidSensor.activate(RoadCode.ZUID);

            // Combine the vehicles from both sensors
            while (!oostSensor.isEmpty()) {
                addVehicle(oostSensor.removeVehicle());
            }
            while (!zuidSensor.isEmpty()) {
                addVehicle(zuidSensor.removeVehicle());
            }

            // Apply combined sensor logic for the West road deck
            // Assuming that the green light should be handled based on combined results
            if (size() > 0) {
                getVerkeersLicht().setGreen(true);
            } else {
                getVerkeersLicht().setGreen(false);
            }
        }
    }
}
