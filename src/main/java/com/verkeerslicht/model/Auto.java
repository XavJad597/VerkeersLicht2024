package com.verkeerslicht.model;


import com.verkeerslicht.constants.AutoType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auto {

    private Road road;
    private int volgNummer;
    private String kentekenNummer;
    private AutoType type;
    private int priorityLevel;
    private int prioCar;


    public Auto( Road road , AutoType type,int volgNummer, int priorityLevel) {
        this.volgNummer = volgNummer;
        this.kentekenNummer = generateKentekenNummer(priorityLevel) ;
        this.priorityLevel = priorityLevel ;
        this.road= road;
        this.type = type;
    }

    //genereeert de kentekennummers
    private String generateKentekenNummer(int priorityLevel) {

        switch (priorityLevel){
            case 1:
                return createKentekenNumber("PO");
            case 2:
                return createKentekenNumber("AM");
            case 3:
                return createKentekenNumber("BR");
            case 4:
                return createKentekenNumber("AU");
        }
        return null;
    }
    //create de nummers
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

