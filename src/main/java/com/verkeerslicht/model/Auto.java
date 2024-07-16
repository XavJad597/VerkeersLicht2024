package com.verkeerslicht.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auto {
    private int id;
    private String licensePlate;
    private String type; // "normal", "police", "ambulance", "firetruck"
    private int priority;

    public Auto(int id, String licensePlate, String type, int priority) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.priority = priority;
    }


    public Auto(String car1) {
    }
}

