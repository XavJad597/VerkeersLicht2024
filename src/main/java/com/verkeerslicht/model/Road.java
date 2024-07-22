package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.PriorityQueue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Road {

    private String roadCode;
    private Boolean isGroen;
    private PriorityQueue voertuigPriorityQueue;
    private AutoStack voertuigStack;

    public Road(String roadCode) {
        this.roadCode = roadCode;
        this.voertuigPriorityQueue = new PriorityQueue(20);
        this.voertuigStack = new AutoStack();
        this.isGroen = false;
    }


    public void addAuto(Auto auto){
        voertuigPriorityQueue.insert(auto);
    }

    @Override
    public String toString() {
        return "Wegdek{" +
                "wegdekCode='" + roadCode + '\'' +
                ", isGroen=" + isGroen +
                ", voertuigPriorityQueue=" + voertuigPriorityQueue +
                ", voertuigStack=" + voertuigStack +
                '}';
    }
}
