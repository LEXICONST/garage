package se.lexicon.garage;

public class Car extends Vehicle{

    private boolean automatic;

    public Car(String make){
        super(make);
    }

    public Car(String make, int topSpeed){
        setMake(make);
        setTopSpeed(topSpeed);
    }

    public Car(String make, int topSpeed, int parkingLot){
        super(make, topSpeed, parkingLot);
    }

}
