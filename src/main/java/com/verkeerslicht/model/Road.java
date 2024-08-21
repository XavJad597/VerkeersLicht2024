package com.verkeerslicht.model;

import com.verkeerslicht.datastructures.AutoStack;
import com.verkeerslicht.datastructures.PriorityQueue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;


@Getter
@Setter
@AllArgsConstructor
public class Road {

    private String roadCode;
    private boolean isGroen; // True if the light is green, false otherwise
    private PriorityQueue voertuigPriorityQueue; // For priority-based vehicle management
    private AutoStack voertuigStack; // For reverse sequence processing

    private static final Comparator<Auto> AUTO_PRIORITY_COMPARATOR = new Comparator<Auto>() {
        @Override
        public int compare(Auto o1, Auto o2) {
            return o1.getPriorityLevel().compareTo(o2.getPriorityLevel());
        }
    };
    public Road(String roadCode) {
        this.roadCode = roadCode;
        this.voertuigPriorityQueue = new PriorityQueue(); // Adjust capacity as needed
        this.voertuigStack = new AutoStack();
        this.isGroen = false;
    }

    public void addAuto(Auto auto) {
        voertuigPriorityQueue.insert(auto); // Add vehicle to priority queue
    }

    public Auto removeAuto() {
        return voertuigPriorityQueue.remove(); // Remove vehicle from priority queue
    }

    public void processVehicles() {
        // Process vehicles from priority queue and then handle reverse sequence with the stack
        while (!voertuigPriorityQueue.isEmpty()) {
            Auto vehicle = removeAuto();
            voertuigStack.push(vehicle); // Use stack for reverse sequence
        }

        // Now process vehicles from the stack (reverse sequence)
        while (!voertuigStack.isEmpty()) {
            Auto vehicle = voertuigStack.pop();
            // Process vehicle (e.g., simulate passing through intersection)
        }
    }

    @Override
    public String toString() {
        return "Road{" +
                "roadCode='" + roadCode + '\'' +
                ", isGroen=" + isGroen + "}\n" +
                voertuigPriorityQueue.toString();  // Priority queue will print items on new lines
    }
}
