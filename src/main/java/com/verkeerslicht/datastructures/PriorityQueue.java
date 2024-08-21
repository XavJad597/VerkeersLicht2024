package com.verkeerslicht.datastructures;

import com.verkeerslicht.constants.PriorityLevel;
import com.verkeerslicht.model.Auto;

import java.util.Comparator;

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

        // If the list is empty, insert the new node at the head
        if (queue.isEmpty()) {
            queue.addToFront(auto);
        } else {
            Node current = queue.getHead();
            Node previous = null;

            // Traverse the list to find the correct position based on priority
            while (current != null && comparePriority(current.getAuto(), auto)) {
                previous = current;
                current = current.getNext();
            }

            // Handle insertion based on priority
            if (auto.getPriorityLevel() == PriorityLevel.AUTO) {
                // Regular vehicles go to the end of the queue
                queue.addToBack(auto);
            } else {
                // If previous is null, it means newNode has the highest priority and should be the new head
                if (previous == null) {
                    queue.addToFront(auto);
                } else {
                    // Insert newNode between previous and current
                    queue.addBetween(previous, current, auto);
                }
            }
        }

        totalSize++;
    }



    private boolean comparePriority(Auto a, Auto b) {
        // Police should have the highest priority
        if (a.getPriorityLevel() == PriorityLevel.POLITIE) {
            return true;  // a should come before b
        } else if (b.getPriorityLevel() == PriorityLevel.POLITIE) {
            return false;  // b should come before a
        }

        // Next priority is Ambulance
        if (a.getPriorityLevel() == PriorityLevel.AMBULANCE) {
            return true;  // a should come before b
        } else if (b.getPriorityLevel() == PriorityLevel.AMBULANCE) {
            return false;  // b should come before a
        }

        // Firefighter has priority over regular cars
        if (a.getPriorityLevel() == PriorityLevel.BRANDWEER) {
            return true;  // a should come before b
        } else if (b.getPriorityLevel() == PriorityLevel.BRANDWEER) {
            return false;  // b should come before a
        }

        // For regular cars (AUTO), maintain their order
        return false;  // Do not flip, a should stay in its place relative to b
    }

    private boolean isPriority(PriorityLevel voertuigPriority) {
        return voertuigPriority == PriorityLevel.POLITIE || voertuigPriority == PriorityLevel.AMBULANCE ||
                voertuigPriority == PriorityLevel.BRANDWEER;
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

