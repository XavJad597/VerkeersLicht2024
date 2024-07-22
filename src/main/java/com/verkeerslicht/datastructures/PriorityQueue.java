package com.verkeerslicht.datastructures;

import com.verkeerslicht.constants.PriorityLevel;
import com.verkeerslicht.model.Auto;

public class PriorityQueue {
    private int maxSize;
    private Auto[] voertuigArray;
    private int aantalvoertuigen;
    private int frontQueue;
    private int rearQueue;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.voertuigArray = new Auto[maxSize];
        this.aantalvoertuigen = 0;
        this.frontQueue = 0;
        this.rearQueue = -1;
    }

    public void insert(Auto auto){
        int i;
        if (aantalvoertuigen == 0){
            voertuigArray[0] = auto;
            aantalvoertuigen++;
        } else {
            for (i = aantalvoertuigen - 1; i >= 0; i--){
                if (isPriority(auto.getPriorityLevel())){
                    voertuigArray[i + 1] = voertuigArray[i];
                }else{
                    break;
                }
            }

            voertuigArray[i + 1] = auto;
            aantalvoertuigen++;
        }
    }

    private boolean isPriority(PriorityLevel voertuigPriority) {
        return voertuigPriority == PriorityLevel.POLITIE || voertuigPriority == PriorityLevel.AMBULANCE ||
                voertuigPriority == PriorityLevel.BRANDWEER;
    }

    public void printPriorityQueue(){
        for (int i = 0;i < aantalvoertuigen; i++){
            System.out.println(voertuigArray[i]);
        }
    }

    public void printQueue(){
        while( !isEmpty() ) {
            Auto n = removeHead();
            System.out.println(n);
            System.out.print(" ");
        }
    }

    // remove end of the voertuigArrayay
    public Auto remove (){
        return voertuigArray[--aantalvoertuigen];
    }

    public Auto removeHead(){
        Auto temp = voertuigArray[frontQueue++]; // get value and incr frontQueue
        if(frontQueue == maxSize) // deal with wraparound
            frontQueue = 0;
        aantalvoertuigen--; // one less item
        return temp;
    }

    public boolean isFull(){
        return aantalvoertuigen == maxSize;
    }

    public boolean isEmpty(){
        return  (aantalvoertuigen == 0);
    }

    // peek end of voertuigArrayay
    public Auto getPeek(){
        return voertuigArray[frontQueue];
    }


    public int size() {
        return aantalvoertuigen;
    }
}
