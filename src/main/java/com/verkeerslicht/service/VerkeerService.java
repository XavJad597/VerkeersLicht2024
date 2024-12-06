package com.verkeerslicht.service;

import com.verkeerslicht.constants.RoadCode;
import com.verkeerslicht.model.Auto;

import java.util.ArrayList;

public interface VerkeerService {
    void priorityVehicles(ArrayList<Auto> oostWeg, ArrayList<Auto> zuidWeg, ArrayList<Auto> westWeg, ArrayList<Auto> noordWeg);

    void stoplichtRoulatie();
}