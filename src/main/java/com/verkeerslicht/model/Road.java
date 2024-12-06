package com.verkeerslicht.model;

import com.verkeerslicht.constants.RoadCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Road {

    private RoadCode roadCode;
    private int wegDekIndex;



    public Road(int wegDekIndex, RoadCode roadCode) {
        this.roadCode = roadCode;
        this.wegDekIndex = wegDekIndex;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
