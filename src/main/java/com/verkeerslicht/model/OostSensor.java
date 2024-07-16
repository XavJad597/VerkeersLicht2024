package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;

public class OostSensor extends Sensor<Auto> {

  public OostSensor(VerkeersLicht verkeersLicht) {
    super(verkeersLicht,false);
}

@Override
public void activate() {
    // check if there are no vehicles on the road
    if (isEmpty()) {
        verkeersLicht.setGreen(false); // skip green light
    }
}
 }

