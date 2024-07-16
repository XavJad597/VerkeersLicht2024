package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.LinkedList;
import com.verkeerslicht.datastructures.Node;
import com.verkeerslicht.datastructures.Queue;
import com.verkeerslicht.datastructures.Stack;

public abstract class Sensor<T> {

    protected VerkeersLicht verkeersLicht;
    protected Queue queue;
    protected Stack stack;

    public Sensor(VerkeersLicht verkeersLicht, boolean isQueueBased) {
        this.verkeersLicht = verkeersLicht;
        if (isQueueBased) {
            this.queue = new Queue();
        } else {
            this.stack = new Stack();
        }
    }

    public abstract void activate();

    public void addVehicle(Auto auto) {
        if (auto instanceof Auto) {
            auto = (Auto) auto;
            if (auto.getType().equals("ambulance") || auto.getType().equals("firetruck")) {
                // High-priority vehicles go to the front of the stack/queue
                stack.push(auto);
            } else {
                // Normal vehicles go to the back of the stack/queue
                stack.pop(auto);
            }
        } else {
            throw new UnsupportedOperationException("Only Auto objects can be added to the sensor");
        }
    }


    public Auto removeVehicle() {
        if (queue!= null) {
            return queue.dequeue();
        } else {
            return stack.pop();
        }
    }

    public boolean isEmpty() {
        if (queue!= null) {
            return queue.isEmpty();
        } else {
            return stack.isEmpty();
        }
    }

    public int size() {
        if (queue!= null) {
            return queue.size();
        } else {
            return stack.size();
        }
    }
}
