package com.verkeerslicht.datastructures;

import com.verkeerslicht.model.Auto;


public class Queue<T> {
    private final LinkedList queue;

    public Queue() {
        queue = new LinkedList();
    }

    public void enqueue(Auto auto) {
        queue.addToFront(auto);
    }

    public Auto dequeue() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.removeFromFront();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.getSize();
    }

    public Auto peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return  queue.peek();
    }

    public void enqueueToBack(Auto auto) {
        queue.addToBack(auto);  // You would need to implement addToBack in your LinkedList class
    }
    public Node getHead() {
        return queue.getHead();
    }


}