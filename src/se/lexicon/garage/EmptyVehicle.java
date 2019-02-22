package se.lexicon.garage;

public class EmptyVehicle extends Vehicle{


    public EmptyVehicle(){
        brand = "empty";
    }

    public EmptyVehicle(String brand) {
        super(brand);
    }
}
