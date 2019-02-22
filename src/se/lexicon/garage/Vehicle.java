package se.lexicon.garage;

public abstract class Vehicle {

    protected String brand;

    public Vehicle(String brand){
        this.brand = brand;
    }

    public String toString(){
        return brand;
    }
}
