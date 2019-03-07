package se.lexicon.garage;

public abstract class Vehicle {

    protected String make;

    protected int topSpeed;

    protected int parkingLot = 0;

    public Vehicle(){
        make = "NoName";
    }

    public Vehicle(String make){
        setMake(make);
    }

    public Vehicle(String make, int topSpeed, int parkingLot){
        setMake(make);
        setTopSpeed(topSpeed);
        setParkingLot(parkingLot);
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


    public void setMake(String make) {
        if (make.matches("^[a-zA-ZåäöüÅÄÖÜ0-9\\s\\-]+$") && make.length() > 0) {
            this.make = make;
        } else {
            throw new IllegalArgumentException("You cannot set the make with zero or illegal characters.");
        }
    }

    public String getMake(){
        return make;
    }

    public int getParkingLot(){
        return parkingLot;
    }

    public void setParkingLot(int parkingLot){
        if(parkingLot < 1 || parkingLot > Garage.MAX_PARKING_LOT_NUMBER)
            throw new IllegalArgumentException("The parking lot number has to be within the range 1-72.");

        else{
            this.parkingLot = parkingLot;
        }
    }

    public String toString() {
        return make;
    }
}
