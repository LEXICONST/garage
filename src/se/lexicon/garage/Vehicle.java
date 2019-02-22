package se.lexicon.garage;

public abstract class Vehicle {

    protected String brand;

    public Vehicle(){
        brand = "NoName";
    }

    public Vehicle(String brand){
        setBrand(brand);
    }

    public void setBrand(String brand) {
        if (brand.matches("^[a-zA-ZåäöüÅÄÖÜ\\s\\-]+$") && brand.length() > 0) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("You cannot set the brand with zero or illegal characters.");
        }
    }

    public String toString() {
        return brand;
    }
}
