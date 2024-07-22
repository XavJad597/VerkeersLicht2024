package com.verkeerslicht.model;


import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.AutoNode;

public class WestSensor extends Sensor<Auto> {


    private OostSensor oostSensor;
    private ZuidSensor zuidSensor;


    public WestSensor(VerkeersLicht verkeersLicht, LinkedList<Auto> node) {
        super(verkeersLicht, false);
        this.oostSensor = new OostSensor(verkeersLicht);
        this.zuidSensor = new ZuidSensor(verkeersLicht);

    }

    public WestSensor(VerkeersLicht verkeersLicht) {
        super();
    }

    @Override
    public void activate() {
        // combination of OostSensor and ZuidSensor
        oostSensor.activate();
        zuidSensor.activate();

        // combine the vehicles from both sensors
        while (!oostSensor.isEmpty()) {
            addVehicle(oostSensor.removeVehicle());
        }
        while (!zuidSensor.isEmpty()) {
            addVehicle(zuidSensor.removeVehicle());
        }
    }
}
