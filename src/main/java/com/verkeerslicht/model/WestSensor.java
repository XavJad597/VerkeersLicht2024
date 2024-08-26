package com.verkeerslicht.model;


import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.LinkedList;


public class WestSensor extends Sensor {


    private OostSensor oostSensor;
    private ZuidSensor zuidSensor;
    private Road westRoad;
    private Road oostRoad;



    public WestSensor(VerkeersLicht verkeersLicht,Road oostRoad,Road zuidRoad,Road westRoad) {
        super(verkeersLicht);
        this.oostSensor = new OostSensor(verkeersLicht,oostRoad);
        this.zuidSensor = new ZuidSensor(verkeersLicht,zuidRoad);
        this.westRoad = westRoad;
    }

    @Override
    public void activate(RoadCode roadCode, AutoStack globalStack) {
        if (roadCode == RoadCode.WEST) {
            // Activate both OostSensor and ZuidSensor
            oostSensor.activate(RoadCode.OOST,globalStack);
            zuidSensor.activate(RoadCode.ZUID,globalStack);

            // Combine the vehicles from both sensors
            while (!oostSensor.isEmpty()) {
                addVehicle(oostSensor.removeVehicle());
            }
            while (!zuidSensor.isEmpty()) {
                addVehicle(zuidSensor.removeVehicle());
            }

            // Apply combined sensor logic for the West road deck
            // Assuming that the green light should be handled based on combined results
          while (westRoad.getVoertuigPriorityQueue().size() > 0) {
                getVerkeersLicht().setGreen(true);
               Auto auto = westRoad.removeAuto();

               if (auto == null) {
                    break;
               }


                switch (auto.getPriorityLevel()) {
                    case AUTO:
                        System.out.println("auto rijd weg van West : " + auto);
                        break;
                    case AMBULANCE:
                        System.out.println("ambulance rijd weg van West : " + auto);
                        break;
                    case BRANDWEER:
                        System.out.println(" brandweer rijd weg van West : " + auto);
                        break;
                    case POLITIE:
                        System.out.println("politie auto rijd weg van West " + auto);
                        break;
                }

                globalStack.push(auto);


            } if (!globalStack.isEmpty()) {
                getVerkeersLicht().setGreen(true);

            }
                getVerkeersLicht().setGreen(false);
            }
        }
    }
