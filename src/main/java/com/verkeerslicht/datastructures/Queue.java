package com.verkeerslicht.datastructures;

import com.verkeerslicht.model.Auto;


public class Queue {
    private final LinkedList<Auto> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Auto auto) {
        queue.add(auto);
    }

    public Auto dequeue() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        int size = 0;
        Node<Auto> current = queue.getHead();
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
}