package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.Queue;
import com.verkeerslicht.datastructures.AutoStack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Sensor<T> {

    private VerkeersLicht verkeersLicht;
    private Queue queue;


    public Sensor(VerkeersLicht verkeersLicht) {
        this.verkeersLicht = verkeersLicht;
        this.queue = new Queue();
    }

    public Sensor() {
        this.queue = new Queue();
    }

    public abstract void activate();

    public void addVehicle(Auto auto) {
        if (auto != null) {
            queue.enqueue(auto);
        } else {
            throw new UnsupportedOperationException("Only Auto objects can be added to the sensor");
        }
    }

    public Auto removeVehicle() {
        return (Auto) queue.dequeue();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
