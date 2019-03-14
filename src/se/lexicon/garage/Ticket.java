package se.lexicon.garage;

import java.time.LocalDateTime;

public class Ticket {

    private LocalDateTime timeStamp;

    private LocalDateTime expirationTime;

    private Vehicle vehicle;

    private int parkingLot;

    private int serialNumber;

    public Ticket(Vehicle vehicle, int parkingLot){
        this.vehicle = vehicle;
        this.parkingLot = parkingLot;
        timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return "Parked at "+timeStamp+
                "\nExpires at "+timeStamp.plusMinutes(60)+
                "\nParking lot number: "+parkingLot;
    }

}
