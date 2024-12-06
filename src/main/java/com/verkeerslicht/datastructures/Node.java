package com.verkeerslicht.datastructures;


import com.verkeerslicht.model.Auto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private Auto auto;
    private Node next;
    private Node prev;
    private int priorityLevel;

    public Node(Auto auto) {
        this.auto = auto;
        // Ensure priorityLevel is set based on Auto's priority
        this.priorityLevel = auto.getPriorityLevel();
        this.next = null;
        this.prev = null;
    }
    public Node(Auto auto,int priorityLevel) {
        this.auto = auto;
        this.priorityLevel = priorityLevel;
        this.next=null;
    }



}

