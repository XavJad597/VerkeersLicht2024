package com.verkeerslicht.datastructures;


import com.verkeerslicht.constants.PriorityLevel;
import com.verkeerslicht.model.Auto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private Auto auto;
    private Node next;
    private Node prev;
    private PriorityLevel priorityLevel;

    public Node(Auto auto) {
        this.auto = auto;
    }



}

