package com.verkeerslicht.service;

import com.verkeerslicht.constants.AutoType;
import com.verkeerslicht.model.Auto;

import java.util.ArrayList;

import static com.verkeerslicht.constants.RoadEnum.ROADS;


public class VehicleDataInitializer {
    //maakt de wegen aan
    public ArrayList <Auto> initializeOostWeg(){
        ArrayList<Auto> voertuigenOostList = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            voertuigenOostList.add(new Auto(ROADS[0], AutoType.AUTO, i ,4));
        }
        return voertuigenOostList;
    }

    public ArrayList <Auto> initializeZuidWeg(){
        ArrayList<Auto> voertuigenZuidList = new ArrayList<>();
        for(int i = 1; i <= 16; i++) {
            voertuigenZuidList.add(new Auto(ROADS[0], AutoType.AUTO, i ,4));
        }
        voertuigenZuidList.add(new Auto(ROADS[1],AutoType.AUTO,18,4));
        voertuigenZuidList.add(new Auto(ROADS[1],AutoType.BRANDWEER,17,2));
        return voertuigenZuidList;
    }


    public ArrayList <Auto> initializeWestWeg(){
        ArrayList<Auto> voertuigenWestList = new ArrayList<>();
        for(int i = 1; i <= 8; i++) {
            voertuigenWestList.add(new Auto(ROADS[0], AutoType.AUTO, i ,4));
        }

        voertuigenWestList.add(new Auto(ROADS[2],AutoType.POLITIE,9,1));
        for(int i = 10; i <= 14; i++) {
            voertuigenWestList.add(new Auto(ROADS[0], AutoType.AUTO, i ,4));
        }

        return voertuigenWestList;
    }

    public ArrayList <Auto> initializeNoordWeg(){
        ArrayList<Auto> voertuigenNoordList = new ArrayList<>();
        voertuigenNoordList.add(new Auto(ROADS[3],AutoType.AUTO,1,4));
        voertuigenNoordList.add(new Auto(ROADS[3],AutoType.AUTO,2, 4));
        voertuigenNoordList.add(new Auto(ROADS[3], AutoType.AMBULANCE ,3,3));
        voertuigenNoordList.add(new Auto(ROADS[3],AutoType.AUTO ,4,4));

        return voertuigenNoordList;
    }

}
