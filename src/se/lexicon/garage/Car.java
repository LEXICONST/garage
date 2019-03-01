package se.lexicon.garage;

public class Car extends Vehicle{

    private int topSpeed;

    public Car(String brand){
        super(brand);
    }

    public Car(String brand, int topSpeed){
        setBrand(brand);
        setTopSpeed(topSpeed);
    }

    public int getTopSpeed(){
        return topSpeed;
    }

    public void setTopSpeed(int newTopSpeed){
        if(newTopSpeed >= 0){
            topSpeed = newTopSpeed;
        }
        else throw new IllegalArgumentException("The top speed cannot be negative. Know your physics!!!");
    }

}
