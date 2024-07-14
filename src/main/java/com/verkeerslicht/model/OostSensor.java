package com.verkeerslicht.model;

public class OostSensor extends Sensor {

  public OostSensor(VerkeersLicht verkeersLicht) {
    super(verkeersLicht);
}

@Override
public void activate() {
    // check if there are no vehicles on the road
    if (/* no vehicles on the road */) {
        verkeersLicht.setGreen(false); // skip green light
    }
}
 }

