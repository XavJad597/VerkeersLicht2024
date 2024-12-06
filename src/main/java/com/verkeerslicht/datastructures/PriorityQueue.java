package com.verkeerslicht.datastructures;

import com.verkeerslicht.model.Auto;

public class PriorityQueue  {
    private LinkedList queue;
   private Node head;
   private int totalSize;

    public PriorityQueue() {
        this.queue = new LinkedList();
        head = null;
        totalSize = 0;
    }

    public void insert(Auto auto) {
        Node newNode = new Node(auto);
        newNode.setAuto(auto);
        newNode.setPriorityLevel(auto.getPriorityLevel());
       //indien leeg word het voorop gezet
        if (queue.isEmpty()) {
            queue.addToFront(auto);
            return;
        }

        Node current = queue.getHead();
        Node previous = null;

      //kijkt en vergelijkt de prioritylevel van een Auto
        while (current != null && current.getPriorityLevel() <= newNode.getPriorityLevel()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            queue.addToFront(auto);
        } else {
            newNode.setNext(current);
            newNode.setPrev(previous);
            previous.setNext(newNode);
        }

        if (current != null) {
            current.setPrev(newNode);
        } else {
            queue.setTail(newNode);

        }

        totalSize++;
    }


    public Auto remove() {
        return queue.removeFromFront();
    }

    public Auto getPeek() {
        return  queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.getSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = queue.getHead();

        while (current != null) {
            sb.append(current.getAuto().toString()).append("\n");
            current = current.getNext();
        }

        return sb.toString();
    }

    }

