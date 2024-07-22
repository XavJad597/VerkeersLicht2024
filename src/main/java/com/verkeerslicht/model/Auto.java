package com.verkeerslicht.model;


import com.verkeerslicht.constants.PriorityLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auto {
    private int volgNummer;
    private String kentekenNummer;
    private String type; // "normal", "police", "ambulance", "firetruck"
    private PriorityLevel priorityLevel;

    public Auto(int volgNummer, String kentekenNummer, String type, PriorityLevel priorityLevel) {
        this.volgNummer = volgNummer;
        this.kentekenNummer = generateKentekenNummer(priorityLevel) ;
        this.type = type;
        this.priorityLevel = priorityLevel ;
    }
    private String generateKentekenNummer(PriorityLevel priorityLevel) {

        switch (priorityLevel){
            case AUTO:
                return createKentekenNumber("AU");
            case POLITIE:
                return createKentekenNumber("PO");
            case AMBULANCE:
                return createKentekenNumber("AM");
            case BRANDWEER:
                return createKentekenNumber("BR");
        }
        return null;
    }
    private String createKentekenNumber(String letters) {
        int eerste2nummers = (int) Math.round((Math.random() * (100 - 10)) + 10);
        int laatse2nummers = (int) Math.round((Math.random() * (100 - 10)) + 10);
        kentekenNummer = letters + " " + eerste2nummers + laatse2nummers;
        return kentekenNummer;
    }
    public Auto(String car1) {
    }
    @Override
    public String toString() {
        return "Voertuig{" +
                "volgNummer=" + volgNummer +
                ", kentekenNummer='" + kentekenNummer + '\'' +
                ", priorityLevel=" + priorityLevel +
                '}';
    }

}

