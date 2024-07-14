package com.verkeerslicht.datastructures;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    private T auto;
    private Node<T> next;

    public Node(T vehicle) {
        this.auto = vehicle;
        this.next = null;
    }

    public T getVehicle() {
        return auto;
    }
}
