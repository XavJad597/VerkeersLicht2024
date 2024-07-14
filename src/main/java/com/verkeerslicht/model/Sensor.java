package com.verkeerslicht.model;

public abstract class Sensor {
   protected VerkeersLicht verkeersLicht;

    public Sensor(VerkeersLicht verkeersLicht) {
        this.verkeersLicht = verkeersLicht;
    }

    public abstract void activate();
}
