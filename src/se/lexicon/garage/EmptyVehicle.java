package se.lexicon.garage;

public class EmptyVehicle extends Vehicle{


    public EmptyVehicle(){
        make = "empty";
    }

    public EmptyVehicle(String brand) {
        super(brand);
    }
}
