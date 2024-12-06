package com.verkeerslicht.service;

import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.PriorityQueue;
import com.verkeerslicht.datastructures.Queue;
import com.verkeerslicht.model.Auto;

import java.util.ArrayList;


import static com.verkeerslicht.constants.AutoType.*;
import static com.verkeerslicht.constants.RoadEnum.ROADS;

public class VerkeerServiceImpl implements VerkeerService {

    PriorityQueue priorityAutos = new PriorityQueue();
    Queue noordQueue = new Queue();
    Queue zuidQueue = new Queue();
    Queue oostQueue = new Queue();
    Queue westQueue = new Queue();

    AutoStack stack = new AutoStack();

    @Override
    public void priorityVehicles(ArrayList<Auto> oostWeg, ArrayList<Auto> zuidWeg, ArrayList<Auto> westWeg, ArrayList<Auto> noordWeg) {
        for(Auto auto : oostWeg )
            if(auto.getType() == POLITIE || auto.getType() == AMBULANCE || auto.getType() == BRANDWEER)
            {
                priorityAutos.insert(auto);
            }
            else {
                oostQueue.enqueueToBack(auto);
            }

        for(Auto auto : zuidWeg )
            if(auto.getType() == BRANDWEER || auto.getType() == AMBULANCE || auto.getType() == POLITIE){
                priorityAutos.insert(auto);
            }
        else {
             zuidQueue.enqueueToBack(auto);
            }

        for(Auto auto : westWeg )
            if(auto.getType() == POLITIE || auto.getType() == AMBULANCE || auto.getType() == BRANDWEER){
                priorityAutos.insert(auto);
            }
        else {
             westQueue.enqueueToBack(auto);
            }
        for(Auto auto : noordWeg )
            if(auto.getType() == AMBULANCE || auto.getType() == BRANDWEER || auto.getType() == POLITIE){
                priorityAutos.insert(auto);
            }
            else {
                noordQueue.enqueueToBack(auto);
            }
    }

    @Override
    public void stoplichtRoulatie() {
        System.out.println("Speciale voertugen rijden op");
        while (!priorityAutos.isEmpty()) {
            Auto auto = priorityAutos.remove();
            stack.push(auto);
            System.out.println("Speciaal voertuig " + auto.getType() + " met als kentekennr " + auto.getKentekenNummer() + " rijdt op "+ " en met volgnummer"+ auto.getVolgNummer());
        }
        System.out.println();

        int teller = 0;
        for (int wegdekIndex = 0; wegdekIndex < ROADS.length; wegdekIndex++) {
            if (noordQueue.isEmpty() && zuidQueue.isEmpty() && oostQueue.isEmpty()  && westQueue.isEmpty()) {
              System.out.println("Alle wegdekken zijn al leeg");
            System.out.println("Aantal rondes om alle voertuigen op te laten rijden: " + Math.round(teller / 4));
            System.out.println();
            reversePlayback();
                break;
            } else {
                switch (ROADS[wegdekIndex].getWegDekIndex()) {
                    case 0:
                        sensorOost();
                        System.out.println();
                        break;
                    case 1:
                        sensorZuid();
                        System.out.println();
                        break;
                    case 2:
                        sensorWest();
                        System.out.println();
                        break;
                    case 3:
                        sensorNoord();
                        wegdekIndex = -1;
                        System.out.println();
                        break;
                    default:

                        break;
                }
            }
            teller++;
        }
    }

    private void reversePlayback() {
        System.out.println("De voertuigen rijden terug naar hun initiële positie");
        while (!stack.isEmpty()) {
            Auto auto = stack.pop();
            System.out.println(auto.getType() + " met als kentekenNr " + auto.getKentekenNummer() + " rijdt terug naar wegdek " +"met volgnummer "+ auto.getVolgNummer() + " en op wegdek " + auto.getRoad().getRoadCode().name());
        }
    }

    private void normaleSituatie(Queue queue) {
        for (int i = 0; i < 5; i++) {
            if (!queue.isEmpty()) {
                oprijden(queue);
            } else {
                break;
            }
        }
    }
    private void oprijden(Queue queue) {
        Auto auto = queue.dequeue();
        System.out.println(auto.getType() + " met als kentekenNr " + auto.getKentekenNummer() + " rijdt op"+ " en met volgnummer"+ auto.getVolgNummer());
        stack.push(auto);
    }

    private void sensorNoord() {
        int autos = noordQueue.size();
        if (!noordQueue.isEmpty()) {
            System.out.println("Sensor Noord wordt geactiveerd");
            if (autos < 5) {
                System.out.println("Stoplicht Noord springt op groen");

                for (int voertuigenIndex = 0; voertuigenIndex < autos; voertuigenIndex++) {
                    if (!noordQueue.isEmpty()) {
                        oprijden(noordQueue);
                    } else {
                        System.out.println("Stoplicht Noord springt op rood");
                        break;
                    }
                }
            } else {
                normaleSituatie(noordQueue);
            }
        } else {
            System.out.println("Wegdek Noord is leeg");
        }
    }

    private void sensorZuid() {
        if (!zuidQueue.isEmpty()) {
            System.out.println("Sensor Zuid wordt geactiveerd");
            if (zuidQueue.size() > 10) {
                System.out.println("Stoplicht Zuid springt op groen");
                for (int voertuigenIndex = 0; voertuigenIndex < 10; voertuigenIndex++) {
                    if (!zuidQueue.isEmpty()) {
                        oprijden(zuidQueue);
                    } else {
                        System.out.println("Wegdek Zuid is leeg");
                        break;
                    }
                }
            } else {
                normaleSituatie(zuidQueue);
            }
        } else {
            System.out.println("Wegdek Zuid is leeg");
        }
    }

    private void sensorOost() {
        System.out.println("Sensor Oost wordt geactiveerd");
        if (!oostQueue.isEmpty()) {
            System.out.println("Stoplicht Oost springt op groen");
            normaleSituatie(oostQueue);
        } else {
            System.out.println("Wegdek Oost is leeg");
        }
    }
    private void sensorWest() {
        System.out.println("Sensor West wordt geactiveerd");
        if (westQueue.size() > 10) {
            System.out.println("Stoplicht West springt op groen");
            for (int voertuigenIndex = 0; voertuigenIndex < 10; voertuigenIndex++) {
                if (!westQueue.isEmpty()) {
                    oprijden(westQueue);
                } else {
                    System.out.println("Wegdek West is leeg");
                    break;
                }
            }
        } else {
            normaleSituatie(westQueue);
        }
    }
}
