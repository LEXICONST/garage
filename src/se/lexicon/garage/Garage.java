package se.lexicon.garage;

import java.util.ArrayList;

public class Garage implements GarageInterface<Vehicle> {

    private ArrayList<Vehicle> vehicles = new ArrayList<>(72);

    public int park(Vehicle vehicle){
        vehicles.add(vehicle);
        return vehicles.indexOf(vehicle);
    }

    public Vehicle find(int parkingLot){
        return vehicles.get(parkingLot);
    }

    public Vehicle unpark(int parkingLot){
        Vehicle temp = vehicles.get(parkingLot);
        vehicles.remove(parkingLot);
        return temp;
    }

    public String toString() {
        String output = "";
        for(Vehicle vehicle : vehicles){
            output += "Lot nr "+vehicles.indexOf(vehicle)+": "+vehicle + "\n";
        }
        return output;
    }
}
