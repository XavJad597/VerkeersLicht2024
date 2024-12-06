package com.verkeerslicht.app;

import com.verkeerslicht.model.*;
import com.verkeerslicht.service.VehicleDataInitializer;
import com.verkeerslicht.service.VerkeerService;
import com.verkeerslicht.service.VerkeerServiceImpl;

import java.util.ArrayList;

import static com.verkeerslicht.constants.RoadCode.*;

public class Application {
    public static void main(String[] args) {
        VehicleDataInitializer initializer = new VehicleDataInitializer();
        VerkeerService service = new VerkeerServiceImpl();


        ArrayList<Auto> voertuigenNoordList = initializer.initializeNoordWeg();
        ArrayList<Auto> voertuigenZuidList = initializer.initializeZuidWeg();
        ArrayList<Auto> voertuigenOostList = initializer.initializeOostWeg();
        ArrayList<Auto> voertuigenWestList = initializer.initializeWestWeg();



        service.priorityVehicles(voertuigenOostList,voertuigenZuidList,voertuigenWestList,voertuigenNoordList);
        service.stoplichtRoulatie();


    }


}

